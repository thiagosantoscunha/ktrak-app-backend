package br.com.ktrak.domain.converters;

import br.com.ktrak.Utils.LocalFormatter;
import br.com.ktrak.domain.dto.RecessoDto;
import br.com.ktrak.domain.entities.RecessoEntity;
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
