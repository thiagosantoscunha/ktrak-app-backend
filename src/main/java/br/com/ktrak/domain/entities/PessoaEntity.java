package br.com.ktrak.domain.entities;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Data
@Table(name = "pessoas")
@Entity
public class PessoaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(length = 64, nullable = false)
    protected String nome;

    @Column(nullable = false)
    protected LocalDate dataNascimento;

    @Column(length = 64, nullable = false)
    protected String logradouro;

    @Column(length = 8, nullable = false)
    protected String cep;

    @Column(length = 64, nullable = false)
    protected String bairro;

    @Column(length = 64, nullable = false)
    protected String cidade;

    @Column(length = 64, nullable = false)
    protected String estado;

    @Column(unique = true)
    protected String digital;

    public PessoaEntity() {
    }

}
