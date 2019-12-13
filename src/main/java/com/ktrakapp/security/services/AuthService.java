package com.ktrakapp.security.services;

import com.ktrakapp.Utils.Utils;
import com.ktrakapp.domain.dto.AlunoDto;
import com.ktrakapp.domain.dto.AlunoLogadoDto;
import com.ktrakapp.domain.dto.UserRequestDto;
import com.ktrakapp.domain.entities.AlunoEntity;
import com.ktrakapp.domain.entities.PessoaEntity;
import com.ktrakapp.domain.entities.converters.AlunoConverter;
import com.ktrakapp.domain.entities.converters.UserConverter;
import com.ktrakapp.domain.exceptions.BadRequestException;
import com.ktrakapp.domain.repositories.PessoaRepository;
import com.ktrakapp.security.entities.UserEntity;
import com.ktrakapp.security.enums.Role;
import com.ktrakapp.security.repositories.AuthRepository;
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

import static com.ktrakapp.security.settings.SecurityConstants.EXPIRATION_TIME;
import static com.ktrakapp.security.settings.SecurityConstants.SECRET;

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
