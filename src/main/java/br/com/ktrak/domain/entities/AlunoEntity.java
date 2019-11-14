package br.com.ktrak.domain.entities;


import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "alunos")
public class AlunoEntity extends PessoaEntity {

    public AlunoEntity() {
    }

    public AlunoEntity(Long id, String nome, LocalDate dataNascimento, String cep, String logradouro, String bairro, String cidade, String estado) {
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
