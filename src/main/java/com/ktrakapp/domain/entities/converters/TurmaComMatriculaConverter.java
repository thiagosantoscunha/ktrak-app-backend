package com.ktrakapp.domain.entities.converters;

import com.ktrakapp.domain.dto.TurmaDto;
import com.ktrakapp.domain.entities.TurmaEntity;
import org.springframework.stereotype.Service;

@Service
public class TurmaComMatriculaConverter extends Converter<TurmaDto, TurmaEntity> {

    public TurmaComMatriculaConverter() {
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
