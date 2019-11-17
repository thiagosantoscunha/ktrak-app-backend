package br.com.ktrak.domain.converters;

import br.com.ktrak.Utils.LocalFormatter;
import br.com.ktrak.domain.dto.TurmaDto;
import br.com.ktrak.domain.entities.TurmaEntity;
import org.springframework.stereotype.Service;

@Service
public class TurmaConverter extends Converter<TurmaDto, TurmaEntity> {

    public TurmaConverter() {
        super(
            fromDto -> {
                TurmaEntity entity = new TurmaEntity();
                entity.setId(fromDto.getId());
                entity.setDisciplina(new DisciplinaConverter().toEntity(fromDto.getDisciplina()));
                entity.setProfessor(new ProfessorConverter().toEntity(fromDto.getProfessor()));
                entity.setDiaHoraAulas(new DiaHoraAulaConverter().toEntityList(fromDto.getDiaHoraAulas()));
                return entity;
            },
            fromEntity -> new TurmaDto(
                fromEntity.getId(),
                new ProfessorConverter().toDto(fromEntity.getProfessor()),
                new DisciplinaConverter().toDto(fromEntity.getDisciplina()),
                new DiaHoraAulaConverter().toDtoList(fromEntity.getDiaHoraAulas())
            )
        );
    }
}
