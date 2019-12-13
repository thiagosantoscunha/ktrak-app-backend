package br.com.ktrak.domain.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@Table(name = "matriculas")
public class MatriculaEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "aluno_id", nullable = false)
    @ManyToOne
    private AlunoEntity aluno;

    @JoinColumn(name = "turma_id", nullable = false)
    @ManyToOne
    private TurmaEntity turma;

    @ManyToMany
    @JoinTable(
            name="matricula_dia_letivo",
            joinColumns = @JoinColumn(name="matricula_id", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name="dia_letivo_id", referencedColumnName="id")
    )
    private List<DiaLetivoEntity> diasLetivos = new ArrayList<>();

    @Column(nullable = false, length = 12, unique = true)
    private String numero;

}
