package br.com.ktrak.domain.converters;

import br.com.ktrak.Utils.LocalFormatter;
import br.com.ktrak.domain.dto.FeriadoDto;
import br.com.ktrak.domain.entities.FeriadoEntity;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class FeriadoConverter extends Converter<FeriadoDto, FeriadoEntity> {

    public FeriadoConverter() {
        super(
            fromDto -> {
                FeriadoEntity entity = new FeriadoEntity();
                entity.setId(fromDto.id);
                entity.setData(LocalFormatter.toLocalDate(fromDto.data));
                return entity;
            },
            fromEntity -> new FeriadoDto(
                fromEntity.getId(),
                fromEntity.getData().toString()
            )
        );
    }

}
