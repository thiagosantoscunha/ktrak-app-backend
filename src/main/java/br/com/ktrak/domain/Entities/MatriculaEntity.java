package br.com.ktrak.domain.entities;

import java.util.List;

public class MatriculaEntity {
    private Long id;
    private String numero;
    private Integer faltas;
    private Double nota;
    private AlunoEntity aluno;
    private TurmaEntity turma;
    private List<MatriculaDiaLetitvoEntity> matriculaDiaLetitvo;
}
