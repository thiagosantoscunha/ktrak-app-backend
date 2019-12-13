package com.ktrakapp.domain.entities;

import lombok.Data;

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

}
