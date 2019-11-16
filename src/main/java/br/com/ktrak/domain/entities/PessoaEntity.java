package br.com.ktrak.domain.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Table(name = "pessoas")
@Entity
@ToString @EqualsAndHashCode
public class PessoaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
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

    public PessoaEntity() {
    }

}
