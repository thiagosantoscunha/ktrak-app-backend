package br.com.ktrak.domain.converters;

import br.com.ktrak.Utils.LocalFormatter;
import br.com.ktrak.domain.dto.SemestreDto;
import br.com.ktrak.domain.entities.SemestreEntity;
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
