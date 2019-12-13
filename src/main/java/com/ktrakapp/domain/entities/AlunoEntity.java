package com.ktrakapp.domain.entities;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "alunos")
@EqualsAndHashCode(callSuper = false)
public class AlunoEntity extends PessoaEntity {

    @Getter
    @Setter
    @OneToMany(mappedBy = "aluno")
    private List<MatriculaEntity> matriculas = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name="turma_aluno",
            joinColumns = @JoinColumn(name="aluno_id", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name="turma_id", referencedColumnName="id")
    )
    private List<TurmaEntity> turmas = new ArrayList<>();

    public AlunoEntity() {
    }

    public AlunoEntity(Long id, String nome, LocalDate dataNascimento, String cep, String logradouro, String bairro, String cidade, String estado, Boolean status) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.status = status;
    }
}
