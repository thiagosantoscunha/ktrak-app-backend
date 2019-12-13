package com.ktrakapp.domain.entities.converters;

import com.ktrakapp.Utils.LocalFormatter;
import com.ktrakapp.domain.dto.SemestreDto;
import com.ktrakapp.domain.entities.SemestreEntity;
import org.springframework.stereotype.Service;


@Service
public class SemestreConverter extends Converter<SemestreDto, SemestreEntity> {
    public SemestreConverter() {
        super(fromDto -> {
            SemestreEntity entity = new SemestreEntity();
            entity.setId(fromDto.id);
            entity.setDataInicio(LocalFormatter.toLocalDate(fromDto.dataInicio));
            entity.setDataFim(LocalFormatter.toLocalDate(fromDto.dataFim));
            return entity;
        }, fromEntity -> new SemestreDto(
                fromEntity.getId(),
                fromEntity.getDataInicio().toString(),
                fromEntity.getDataFim().toString()
        ));
    }
}
