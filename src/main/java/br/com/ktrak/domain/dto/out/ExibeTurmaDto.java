package br.com.ktrak.domain.dto.out;

import br.com.ktrak.domain.entities.TurmaEntity;

import java.util.ArrayList;
import java.util.List;

public class ExibeTurmaDto {

    public Long id;
    public ExibeProfessorDto professor;
    public ExibeDisciplinaDto disciplina;

    public void toDto(TurmaEntity entity) {
        id = entity.getId();

        professor = new ExibeProfessorDto();
        professor.toDto(entity.getProfessor());

        disciplina = new ExibeDisciplinaDto();
        disciplina.toDto(entity.getDisciplina());
    }

}
