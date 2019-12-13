package com.ktrakapp.domain.dto.in;


import com.ktrakapp.domain.entities.TurmaEntity;

public class InsereTurmaDto {
    public InsereProfessorDto professor;
    public InsereDisciplinaDto disciplina;

    public TurmaEntity toEntity() {
        TurmaEntity entity = new TurmaEntity();
        entity.setProfessor(professor.toEntity());
        entity.setDisciplina(disciplina.toEntity());
        return entity;
    }
}
