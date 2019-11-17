package br.com.ktrak.domain.entities;

import br.com.ktrak.domain.entities.ids.MatriculaId;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


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

    @Column(nullable = false, length = 12, unique = true)
    private String numero;

    @Column
    private Integer faltas;

    @Column
    private Double n1;

    @Column
    private Double n2;

    @Column
    private Double n3;

    @Column
    private Double vf;

    @Column
    private Double media;
}
