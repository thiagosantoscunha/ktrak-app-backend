package br.com.ktrak.domain.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity(name = "pessoas")
public class PessoaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 150)
    private String nome;

    @Column()
    private LocalDateTime dataNascimento;

    @Column(length = 64)
    private String bairro;

    @Column(length = 64)
    private String cidade;

    @Column(length = 64)
    private String estado;

    @Column(length = 255)
    private String digital;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDateTime getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDateTime dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDigital() {
        return digital;
    }

    public void setDigital(String digital) {
        this.digital = digital;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PessoaEntity that = (PessoaEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
