package br.com.ktrak.domain.converters;

import br.com.ktrak.domain.dto.TurmaDto;
import br.com.ktrak.domain.entities.TurmaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class TurmaConverter extends Converter<TurmaDto, TurmaEntity> {

    @Autowired
    private DisciplinaConverter disciplinaConverter;

    @Autowired
    private ProfessorConverter professorConverter;

    public TurmaConverter() {
        super(
            fromDto -> {
                TurmaEntity entity = new TurmaEntity();
                entity.setId(fromDto.id);
                entity.setDisciplina(disciplinaConverter.toEntity(fromDto.disciplina));
                entity.setProfessor(professorConverter.toEntity(fromDto.professor));
                return entity;
            },
            fromEntity -> new TurmaDto(
                fromEntity.getId(),
                professorConverter.toDto(fromEntity.getProfessor()),
                disciplinaConverter.toDto(fromEntity.getDisciplina())
            )
        );
    }
}
