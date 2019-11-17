package br.com.ktrak.domain.entities;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "dias_letivos")
public class DiaLetivoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private LocalDateTime dataHora;

    @ManyToOne
    private TurmaEntity turma;

    @ManyToMany(mappedBy = "diasLetivos")
    private List<MatriculaEntity> matriculas = new ArrayList<>();

    @Column
    @ColumnDefault("true")
    private boolean isPresente;

}
