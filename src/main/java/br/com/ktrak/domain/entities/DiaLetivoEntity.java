package br.com.ktrak.domain.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "dias_letivos")
@ToString @EqualsAndHashCode
public class DiaLetivoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @Column(unique = true, nullable = false)
    @Getter @Setter
    private LocalDateTime dataHora;

    @ManyToOne
    @Getter @Setter
    private TurmaEntity turma;

//    @OneToMany
//    private List<MatriculaDiaLetitvoEntity> matriculaDiaLetivos = new ArrayList<>();

}
