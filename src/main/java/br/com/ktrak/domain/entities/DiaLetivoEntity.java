package br.com.ktrak.domain.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "dias_letivos")
public class DiaLetivoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private LocalDate data;

    @ManyToOne
    private TurmaEntity turma;

//    private List<MatriculaDiaLetitvoEntity> matriculaDiaLetivos;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public TurmaEntity getTurma() {
        return turma;
    }

    public void setTurma(TurmaEntity turma) {
        this.turma = turma;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiaLetivoEntity that = (DiaLetivoEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(data, that.data) &&
                Objects.equals(turma, that.turma);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, data, turma);
    }
}
