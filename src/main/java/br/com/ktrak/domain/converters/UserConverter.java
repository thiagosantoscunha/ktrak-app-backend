package br.com.ktrak.domain.converters;

import br.com.ktrak.Utils.LocalFormatter;
import br.com.ktrak.security.dto.UserDto;
import br.com.ktrak.security.entities.UserEntity;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

@Service
public class UserConverter extends Converter<UserDto, UserEntity> {
    public UserConverter() {
        super(fromDto -> {
            UserEntity entity = new UserEntity();
            entity.setId(fromDto.id);
            entity.setUsername(fromDto.username);
            entity.setPassword(fromDto.password);
            entity.setCriadoEm(LocalFormatter.toLocalDateTime(fromDto.criadoEm));
            entity.setAtualizadoEm(LocalFormatter.toLocalDateTime(fromDto.atualizadoEm));
            return entity;
        }, fromEntity -> new UserDto(
                fromEntity.getId(),
                fromEntity.getUsername(),
                fromEntity.getPassword(),
                fromEntity.getCriadoEm().toString(),
                fromEntity.getAtualizadoEm().toString()
        ));
    }
}
