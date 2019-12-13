package com.ktrakapp.domain.entities.converters;

import com.ktrakapp.Utils.LocalFormatter;
import com.ktrakapp.domain.dto.RecessoDto;
import com.ktrakapp.domain.entities.RecessoEntity;
import org.springframework.stereotype.Service;


@Service
public class RecessoConverter extends Converter<RecessoDto, RecessoEntity> {

    public RecessoConverter() {
        super(
            fromDto -> {
                RecessoEntity entity = new RecessoEntity();
                entity.setId(fromDto.id);
                entity.setData(LocalFormatter.toLocalDate(fromDto.data));
                return entity;
            },
            fromEntity -> new RecessoDto(
                fromEntity.getId(),
                fromEntity.getData().toString()
            )
        );
    }

}
