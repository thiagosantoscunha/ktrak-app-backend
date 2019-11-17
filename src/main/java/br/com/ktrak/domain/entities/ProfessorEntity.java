package br.com.ktrak.domain.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public ProfessorEntity(Long id, String nome, LocalDate dataNascimento, String cep, String logradouro, String bairro, String cidade, String estado) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

}
