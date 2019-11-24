package br.com.ktrak.domain.entities;

import br.com.ktrak.domain.enums.Status;
import br.com.ktrak.security.entities.UserEntity;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@EqualsAndHashCode
@Table(name = "pessoas")
@Entity
public class PessoaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    @Column
    protected Long id;

    @Column(length = 64, nullable = false)
    @Getter @Setter
    protected String nome;

    @Column(nullable = false)
    @Getter @Setter
    protected LocalDate dataNascimento;

    @Column(length = 64, nullable = false)
    @Getter @Setter
    protected String logradouro;

    @Column(length = 8, nullable = false)
    @Getter @Setter
    protected String cep;

    @Column(length = 64, nullable = false)
    @Getter @Setter
    protected String bairro;

    @Column(length = 64, nullable = false)
    @Getter @Setter
    protected String cidade;

    @Column(length = 64, nullable = false)
    @Getter @Setter
    protected String estado;

    @Column(unique = true)
    @Getter @Setter
    protected String digital;

    @Getter @Setter
    @ManyToOne
    protected UserEntity user;

    @Getter @Setter
    @Column
    @ColumnDefault("true")
    protected Boolean status = true;



}
