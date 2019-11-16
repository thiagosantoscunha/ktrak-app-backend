package br.com.ktrak.domain.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "turmas")
@ToString @EqualsAndHashCode
public class TurmaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "turma_id")
    @Getter @Setter
    private List<DiaHoraAulaEntity> diaHoraAulas = new ArrayList<>();

    @ManyToOne
    @Getter @Setter
    private ProfessorEntity professor;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "turma_id")
    @Getter @Setter
    private List<DiaLetivoEntity> diasLetivos = new ArrayList<>();

    @ManyToOne()
    @JoinColumn(name = "disciplina_id", nullable = false)
    @Getter @Setter
    private DisciplinaEntity disciplina;
}
