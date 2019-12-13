package br.com.ktrak.security.services;

import br.com.ktrak.Utils.Utils;
import br.com.ktrak.domain.converters.AlunoConverter;
import br.com.ktrak.domain.converters.UserConverter;
import br.com.ktrak.domain.dto.AlunoDto;
import br.com.ktrak.domain.dto.AlunoLogadoDto;
import br.com.ktrak.domain.dto.UserRequestDto;
import br.com.ktrak.domain.entities.AlunoEntity;
import br.com.ktrak.domain.entities.PessoaEntity;
import br.com.ktrak.domain.exceptions.BadRequestException;
import br.com.ktrak.domain.repositories.PessoaRepository;
import br.com.ktrak.security.dto.UserDto;
import br.com.ktrak.security.entities.UserEntity;
import br.com.ktrak.security.enums.Role;
import br.com.ktrak.security.repositories.AuthRepository;
import com.fasterxml.jackson.databind.util.JSONPObject;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Date;
import java.util.Optional;

import static br.com.ktrak.security.settings.SecurityConstants.EXPIRATION_TIME;
import static br.com.ktrak.security.settings.SecurityConstants.SECRET;

@Service
public class AuthService {

    @Autowired
    private AuthRepository authRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private AlunoConverter alunoConverter;

    @Autowired
    private UserConverter converter;

    public AlunoLogadoDto login(UserRequestDto userDto) {

        UserEntity user = authRepository.findByUsername(userDto.getUsername());

        if (user != null) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            BCrypt.checkpw(userDto.getPassword(), user.getPassword());
        } else {
            throw new BadRequestException("Usuário ou senha inválida");
        }

        String token = Jwts.builder()
                .setSubject(user.getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();

        PessoaEntity pessoa = pessoaRepository.findByUser(user);
        pessoa.setUser(user);

        AlunoLogadoDto alunoLogadoDto = new AlunoLogadoDto();
        alunoLogadoDto.setAluno(alunoConverter.toDto((AlunoEntity) pessoa));
        alunoLogadoDto.setToken(token);
        return alunoLogadoDto;
    }

    public UserEntity saveByAluno(AlunoDto alunoDto) {
        UserEntity entity = new UserEntity();
        entity.setUsername(Utils.getUsernameByFullname(alunoDto.getNome()));
        entity.setCriadoEm(LocalDateTime.now());
        entity.setAtualizadoEm(LocalDateTime.now());
        entity.setRole(Role.ADMINISTRADOR);
        entity.setPassword(
                Utils.encodePassword(
                        Utils.getUsernameByFullname(alunoDto.getNome()) + entity.getCriadoEm().getYear()
                )
        );
        UserEntity userResponse = authRepository.save(entity);
        return userResponse;
    }

    public void buscaPorJwt(String jwt) {
        String[] values = jwt.split(" ");
        String token = values[values.length - 1];
        String[] parts = token.split("\\.");
        Base64.Decoder decoder = Base64.getDecoder();

        String payload = new String(decoder.decode(parts[1]));
        JSONParser parser = new JSONParser(payload);
        System.out.println(parser);
    }

    public boolean existePorUsername(String username) {
        return authRepository.existsByUsername(username);
    }
}
