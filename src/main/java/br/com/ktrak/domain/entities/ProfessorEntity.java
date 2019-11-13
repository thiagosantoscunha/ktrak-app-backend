package br.com.ktrak.domain.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "professores")
public class ProfessorEntity extends PessoaEntity {

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="professor_id")
    private List<TurmaEntity> turmas = new ArrayList<>();

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


    public List<TurmaEntity> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<TurmaEntity> turmas) {
        this.turmas = turmas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ProfessorEntity that = (ProfessorEntity) o;
        return Objects.equals(turmas, that.turmas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), turmas);
    }
}
