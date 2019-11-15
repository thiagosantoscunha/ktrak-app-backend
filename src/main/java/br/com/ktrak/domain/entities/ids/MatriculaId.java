package br.com.ktrak.domain.entities.ids;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MatriculaId implements Serializable {

    @Column(name = "aluno_id")
    private Long alunoId;

    @Column(name = "dia_letivo_id")
    private Long diaLetivoId;

    public Long getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(Long alunoId) {
        this.alunoId = alunoId;
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
        MatriculaId that = (MatriculaId) o;
        return Objects.equals(alunoId, that.alunoId) &&
                Objects.equals(diaLetivoId, that.diaLetivoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alunoId, diaLetivoId);
    }
}
