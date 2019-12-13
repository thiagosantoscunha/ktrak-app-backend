package com.ktrakapp.domain.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "professores")
public class ProfessorEntity extends PessoaEntity {

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name="professor_id")
//    private List<TurmaEntity> turmas = new ArrayList<>();

    public ProfessorEntity() {
    }

    public ProfessorEntity(Long id, String nome, LocalDate dataNascimento, String cep, String logradouro, String bairro, String cidade, String estado, Boolean status) {
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
