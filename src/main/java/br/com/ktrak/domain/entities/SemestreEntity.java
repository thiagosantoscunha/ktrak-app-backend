package br.com.ktrak.domain.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "semestres")
public class SemestreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDate dataInicio;

    @Column
    private LocalDate dataFim;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SemestreEntity that = (SemestreEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(dataInicio, that.dataInicio) &&
                Objects.equals(dataFim, that.dataFim);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dataInicio, dataFim);
    }
}
