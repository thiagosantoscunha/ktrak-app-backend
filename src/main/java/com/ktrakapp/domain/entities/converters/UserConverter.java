package com.ktrakapp.domain.entities.converters;

import com.ktrakapp.Utils.LocalFormatter;
import com.ktrakapp.security.dto.UserDto;
import com.ktrakapp.security.entities.UserEntity;
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
