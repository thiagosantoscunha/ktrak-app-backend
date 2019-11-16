package br.com.ktrak.domain.entities;

import br.com.ktrak.domain.entities.ids.MatriculaDiaLetivoId;
import br.com.ktrak.domain.entities.ids.MatriculaId;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalIdCache;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor

@Entity(name = "Matricula")
@Table(name = "matriculas")
public class MatriculaEntity implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn
    private AlunoEntity aluno;

    @Id
    @ManyToOne
    @JoinColumn
    private TurmaEntity turma;

    @Column
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
