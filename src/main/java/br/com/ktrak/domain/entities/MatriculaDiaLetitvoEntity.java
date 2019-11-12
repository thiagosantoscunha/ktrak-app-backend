package br.com.ktrak.domain.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "matricula_dia_letivo")
public class MatriculaDiaLetitvoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private boolean presente;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("matricula_id")
    private MatriculaEntity matricula;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("dia_letivo_id")
    private DiaLetivoEntity diaLetivo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isPresente() {
        return presente;
    }

    public void setPresente(boolean presente) {
        this.presente = presente;
    }

    public MatriculaEntity getMatricula() {
        return matricula;
    }

    public void setMatricula(MatriculaEntity matricula) {
        this.matricula = matricula;
    }

    public DiaLetivoEntity getDiaLetivo() {
        return diaLetivo;
    }

    public void setDiaLetivo(DiaLetivoEntity diaLetivo) {
        this.diaLetivo = diaLetivo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatriculaDiaLetitvoEntity that = (MatriculaDiaLetitvoEntity) o;
        return presente == that.presente &&
                Objects.equals(id, that.id) &&
                Objects.equals(matricula, that.matricula) &&
                Objects.equals(diaLetivo, that.diaLetivo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, presente, matricula, diaLetivo);
    }
}
