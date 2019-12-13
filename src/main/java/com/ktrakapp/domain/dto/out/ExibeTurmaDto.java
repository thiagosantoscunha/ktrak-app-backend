package com.ktrakapp.domain.dto.out;


import com.ktrakapp.domain.entities.TurmaEntity;

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
