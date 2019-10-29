package br.com.ktrak.domain.Entities;

import java.util.Date;
import java.util.List;

public class DiaLetivoEntity {
    private Long id;
    private Date data;
    private TurmaEntity turma;
    private List<MatriculaDiaLetitvoEntity> matriculaDiaLetivos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public TurmaEntity getTurma() {
        return turma;
    }

    public void setTurma(TurmaEntity turma) {
        this.turma = turma;
    }

    public List<MatriculaDiaLetitvoEntity> getMatriculaDiaLetivos() {
        return matriculaDiaLetivos;
    }

    public void setMatriculaDiaLetivos(List<MatriculaDiaLetitvoEntity> matriculaDiaLetivos) {
        this.matriculaDiaLetivos = matriculaDiaLetivos;
    }
}
