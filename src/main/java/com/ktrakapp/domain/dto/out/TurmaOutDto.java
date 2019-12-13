package com.ktrakapp.domain.dto.out;


import com.ktrakapp.domain.entities.DisciplinaEntity;
import com.ktrakapp.domain.entities.TurmaEntity;

import java.util.ArrayList;
import java.util.List;

public class TurmaOutDto {

    private TurmaEntity turma;

    public static List<TurmaOutDto> getTurmasDto(Iterable<TurmaEntity> turmas) {
        List<TurmaOutDto> turmasDto = new ArrayList<>();
        for (TurmaEntity turma: turmas) {
            turmasDto.add(new TurmaOutDto(turma));
        }
        return turmasDto;
    }

    public TurmaOutDto(TurmaEntity turma) {
        this.turma = turma;
    }

    public Long getId() {
        return turma.getId();
    }

    public String getProfessor() {
        return turma.getProfessor().getNome();
    }

    public DisciplinaDto getDisciplina() {
        return new DisciplinaDto(turma.getDisciplina());
    }


}

class DisciplinaDto {
    private DisciplinaEntity disciplinaEntity;

    public DisciplinaDto(DisciplinaEntity disciplinaEntity) {
        this.disciplinaEntity = disciplinaEntity;
    }

    public Long getId() {
        return disciplinaEntity.getId();
    }

    public String getNome() {
        return disciplinaEntity.getNome();
    }
}

