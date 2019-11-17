package br.com.ktrak.domain.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

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

//    @OneToMany
//    private List<MatriculaDiaLetitvoEntity> matriculaDiaLetivos = new ArrayList<>();

}
