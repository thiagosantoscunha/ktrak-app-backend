package br.com.ktrak.domain.dto.in;

import br.com.ktrak.domain.entities.TurmaEntity;

public class AtualizaTurmaDto {
    public Long id;
    public InsereProfessorDto professor;
    public InsereDisciplinaDto disciplina;

    public TurmaEntity toEntity() {
        TurmaEntity entity = new TurmaEntity();
        entity.setId(id);
        entity.setProfessor(professor.toEntity());
        entity.setDisciplina(disciplina.toEntity());
        return entity;
    }
}
