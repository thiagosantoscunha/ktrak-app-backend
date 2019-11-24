package br.com.ktrak.security.services;

import br.com.ktrak.Utils.Utils;
import br.com.ktrak.domain.converters.AlunoConverter;
import br.com.ktrak.domain.converters.UserConverter;
import br.com.ktrak.domain.dto.AlunoDto;
import br.com.ktrak.domain.entities.AlunoEntity;
import br.com.ktrak.domain.exceptions.BadRequestException;
import br.com.ktrak.domain.repositories.PessoaRepository;
import br.com.ktrak.security.dto.UserDto;
import br.com.ktrak.security.entities.UserEntity;
import br.com.ktrak.security.enums.Role;
import br.com.ktrak.security.repositories.AuthRepository;
import com.fasterxml.jackson.databind.util.JSONPObject;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Base64;

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

    public AlunoDto login(UserDto userDto) {
        var user = authRepository.findByUsername(userDto.username);
        if (!user.getPassword().equals(userDto.password)) {
            throw new BadRequestException("Usuário ou senha inválida");
        }
        var pessoa = pessoaRepository.findByUser(user);
        return alunoConverter.toDto((AlunoEntity) pessoa);
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
        var userResponse = authRepository.save(entity);
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
}
