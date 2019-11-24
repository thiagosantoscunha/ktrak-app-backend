package br.com.ktrak.domain.converters;

import br.com.ktrak.domain.dto.UserOutDto;
import br.com.ktrak.security.entities.UserEntity;
import org.springframework.stereotype.Service;

import java.util.function.Function;

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
