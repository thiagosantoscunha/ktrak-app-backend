package br.com.ktrak.domain.Entities;

public class MatriculaDiaLetitvoEntity {
    private Long id;
    private boolean presente;
    private MatriculaEntity matricula;
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
}
