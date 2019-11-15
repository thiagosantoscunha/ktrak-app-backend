package br.com.ktrak.domain.converters;

import br.com.ktrak.domain.dto.DisciplinaDto;
import br.com.ktrak.domain.entities.DisciplinaEntity;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class DisciplinaConverter extends Converter<DisciplinaDto, DisciplinaEntity> {
    public DisciplinaConverter() {
        super(
                disciplinaDto -> new DisciplinaEntity(disciplinaDto.id, disciplinaDto.nome),
                disciplinaEntity -> new DisciplinaDto(disciplinaEntity.getId(), disciplinaEntity.getNome())
        );
    }
}
