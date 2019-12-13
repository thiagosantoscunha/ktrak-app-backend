package com.ktrakapp.domain.entities.converters;

import com.ktrakapp.domain.dto.UserOutDto;
import com.ktrakapp.security.entities.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class UserOutConverter extends Converter<UserOutDto, UserEntity> {
    public UserOutConverter() {
        super(fromDto -> {
            return null;
        }, fromEntity -> new UserOutDto(
                fromEntity.getId(),
                fromEntity.getUsername(),
                fromEntity.getRole(),
                fromEntity.getCriadoEm().toString(),
                fromEntity.getAtualizadoEm().toString()
        ));
    }
}
