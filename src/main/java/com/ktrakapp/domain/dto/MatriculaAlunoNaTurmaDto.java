package com.ktrakapp.domain.dto;

import lombok.Getter;

@Getter
public class MatriculaAlunoNaTurmaDto {

    private Long idAluno;
    private Long idTurma;

    public MatriculaAlunoNaTurmaDto(Long idAluno, Long idTurma) {
        this.idAluno = idAluno;
        this.idTurma = idTurma;
    }
}
