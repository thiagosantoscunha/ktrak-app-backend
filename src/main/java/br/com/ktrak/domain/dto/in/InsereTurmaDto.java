package br.com.ktrak.domain.dto.in;

import br.com.ktrak.domain.dto.out.ExibeDisciplinaDto;
import br.com.ktrak.domain.dto.out.ExibeProfessorDto;
import br.com.ktrak.domain.entities.TurmaEntity;

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
