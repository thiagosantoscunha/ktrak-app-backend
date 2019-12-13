package com.ktrakapp.domain.entities.converters;

import com.ktrakapp.domain.dto.DisciplinaDto;
import com.ktrakapp.domain.entities.DisciplinaEntity;
import org.springframework.stereotype.Service;

@Service
public class DisciplinaConverter extends Converter<DisciplinaDto, DisciplinaEntity> {
    public DisciplinaConverter() {
        super(
                disciplinaDto -> new DisciplinaEntity(disciplinaDto.id, disciplinaDto.nome),
                disciplinaEntity -> new DisciplinaDto(disciplinaEntity.getId(), disciplinaEntity.getNome())
        );
    }
}
