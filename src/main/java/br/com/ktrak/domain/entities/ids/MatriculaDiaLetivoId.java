package br.com.ktrak.domain.entities.ids;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MatriculaDiaLetivoId implements Serializable {
    @Column(name = "matricula_id")
    private Long matriculaId;

    @Column(name = "dia_letivo_id")
    private Long diaLetivoId;

    public Long getMatriculaId() {
        return matriculaId;
    }

    public void setMatriculaId(Long matriculaId) {
        this.matriculaId = matriculaId;
    }

    public Long getDiaLetivoId() {
        return diaLetivoId;
    }

    public void setDiaLetivoId(Long diaLetivoId) {
        this.diaLetivoId = diaLetivoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatriculaDiaLetivoId that = (MatriculaDiaLetivoId) o;
        return Objects.equals(matriculaId, that.matriculaId) &&
                Objects.equals(diaLetivoId, that.diaLetivoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matriculaId, diaLetivoId);
    }
}
