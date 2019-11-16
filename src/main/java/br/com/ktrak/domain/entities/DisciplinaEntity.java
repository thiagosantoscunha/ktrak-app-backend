package br.com.ktrak.domain.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "disciplinas")
@ToString @EqualsAndHashCode
public class DisciplinaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @Column(length = 64, unique = true, nullable = false)
    @Getter @Setter
    private String nome;

    @OneToMany(mappedBy = "disciplina")
    @Getter @Setter
    private List<TurmaEntity> turmas = new ArrayList<>();

    public DisciplinaEntity() {
    }

    public DisciplinaEntity(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

}
