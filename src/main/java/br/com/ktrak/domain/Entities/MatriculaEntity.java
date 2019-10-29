package br.com.ktrak.domain.Entities;

import java.util.List;

public class MatriculaEntity {
    private Long id;
    private String numero;
    private Integer faltas;
    private Double nota;
    private AlunoEntity aluno;
    private TurmaEntity turma;
    private List<MatriculaDiaLetitvoEntity> matriculaDiaLetitvo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Integer getFaltas() {
        return faltas;
    }

    public void setFaltas(Integer faltas) {
        this.faltas = faltas;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public AlunoEntity getAluno() {
        return aluno;
    }

    public void setAluno(AlunoEntity aluno) {
        this.aluno = aluno;
    }

    public TurmaEntity getTurma() {
        return turma;
    }

    public void setTurma(TurmaEntity turma) {
        this.turma = turma;
    }

    public List<MatriculaDiaLetitvoEntity> getMatriculaDiaLetitvo() {
        return matriculaDiaLetitvo;
    }

    public void setMatriculaDiaLetitvo(List<MatriculaDiaLetitvoEntity> matriculaDiaLetitvo) {
        this.matriculaDiaLetitvo = matriculaDiaLetitvo;
    }
}
