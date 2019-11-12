package br.com.ktrak.domain.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "matriculas")
public class MatriculaEntity {

    @EmbeddedId
    private Long id;

    @Column(length = 11, unique = true, nullable = false)
    private String numero;

    @Column(nullable = false)
    private Integer faltas;

    @Column
    private Double nota;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("aluno_id")
    private AlunoEntity aluno;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("turma_id")
    private TurmaEntity turma;

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
}
