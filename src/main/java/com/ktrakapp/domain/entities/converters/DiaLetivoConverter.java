package com.ktrakapp.domain.entities.converters;

import com.ktrakapp.Utils.LocalFormatter;
import com.ktrakapp.domain.dto.DiaLetivoDto;
import com.ktrakapp.domain.entities.DiaLetivoEntity;
import org.springframework.stereotype.Service;


@Service
public class DiaLetivoConverter extends Converter<DiaLetivoDto, DiaLetivoEntity> {

    public DiaLetivoConverter() {
        super(fromDto -> {
            DiaLetivoEntity entity = new DiaLetivoEntity();
            entity.setId(fromDto.id);
            entity.setDataHora(LocalFormatter.toLocalDateTime(fromDto.data));
            entity.setTurma(new TurmaConverter().toEntity(fromDto.turma));
            return entity;
        }, fromEntity -> new DiaLetivoDto(
                fromEntity.getId(),
                fromEntity.getDataHora().toString(),
                new TurmaConverter().toDto(fromEntity.getTurma())
        ));
    }

}
