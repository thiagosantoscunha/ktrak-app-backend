package br.com.ktrak.domain.entities;

import java.util.List;

public class AlunoEntity extends PessoaEntity {
    private List<MatriculaEntity> matriculas;

    public List<MatriculaEntity> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<MatriculaEntity> matriculas) {
        this.matriculas = matriculas;
    }
}
