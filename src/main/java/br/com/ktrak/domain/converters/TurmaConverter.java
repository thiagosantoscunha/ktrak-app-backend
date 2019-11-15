package br.com.ktrak.domain.converters;

import br.com.ktrak.domain.dto.TurmaDto;
import br.com.ktrak.domain.entities.TurmaEntity;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class TurmaConverter extends Converter<TurmaDto, TurmaEntity> {

    public TurmaConverter() {
        super(
            fromDto -> {
                TurmaEntity entity = new TurmaEntity();
                entity.setId(fromDto.id);
                entity.setDisciplina(new DisciplinaConverter().toEntity(fromDto.disciplina));
                entity.setProfessor(new ProfessorConverter().toEntity(fromDto.professor));
                return entity;
            },
            fromEntity -> new TurmaDto(
                fromEntity.getId(),
                new ProfessorConverter().toDto(fromEntity.getProfessor()),
                new DisciplinaConverter().toDto(fromEntity.getDisciplina())
            )
        );
    }
}
