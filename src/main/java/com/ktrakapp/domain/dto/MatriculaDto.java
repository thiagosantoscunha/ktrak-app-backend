package com.ktrakapp.domain.dto;

import lombok.Getter;

@Getter
public class MatriculaDto {
    private Long id;
    private AlunoDto aluno;
    private TurmaDto turma;

    public MatriculaDto() {
    }

    public MatriculaDto(Long id, AlunoDto aluno, TurmaDto turma) {
        this.id = id;
        this.aluno = aluno;
        this.turma = turma;
    }

}
