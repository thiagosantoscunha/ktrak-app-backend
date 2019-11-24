package br.com.ktrak.domain.entities;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;


@Data
@Entity
@Table(name = "presenciamentos")
public class PresenciamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "matricula_id", nullable = false)
    private MatriculaEntity matricula;

    @ManyToOne
    @JoinColumn(name = "dia_letivo_id", nullable = false)
    private DiaLetivoEntity diaLetivo;

    @Column
    @ColumnDefault("true")
    private Boolean isPresente;
}
