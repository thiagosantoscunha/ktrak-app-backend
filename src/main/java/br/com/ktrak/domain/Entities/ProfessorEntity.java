package br.com.ktrak.domain.Entities;

import java.util.List;

public class ProfessorEntity {
    private List<TurmaEntity> turmas;

    public List<TurmaEntity> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<TurmaEntity> turmas) {
        this.turmas = turmas;
    }
}