package com.ktrakapp.domain.entities;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "turmas")
public class TurmaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "turma_id")
    private List<DiaHoraAulaEntity> diaHoraAulas = new ArrayList<>();

    @ManyToOne
    private ProfessorEntity professor;

    @ManyToOne()
    @JoinColumn(name = "disciplina_id", nullable = false)
    private DisciplinaEntity disciplina;

    @ManyToMany(mappedBy = "turmas")
    private List<AlunoEntity> alunos = new ArrayList<>();

    @Column
    @ColumnDefault("false")
    private boolean isAberta;
}
