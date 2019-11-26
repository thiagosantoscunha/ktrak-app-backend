package br.com.ktrak.domain.converters;

import br.com.ktrak.Utils.LocalFormatter;
import br.com.ktrak.domain.dto.DiaLetivoDto;
import br.com.ktrak.domain.entities.DiaLetivoEntity;
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
