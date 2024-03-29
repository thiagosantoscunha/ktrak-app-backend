package com.ktrakapp.domain.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "disciplinas")
public class DisciplinaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 64, unique = true, nullable = false)
    private String nome;

//    @OneToMany(mappedBy = "disciplina")
//    private List<TurmaEntity> turmas = new ArrayList<>();

    public DisciplinaEntity() {
    }

    public DisciplinaEntity(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

}
