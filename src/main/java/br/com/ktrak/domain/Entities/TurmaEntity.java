package br.com.ktrak.domain.Entities;

public class TurmaEntity {
    private Long id;
    private DisciplinaEntity disciplina;
    private DiaLetivoEntity diaLetivosEntity;
    private ProfessorEntity professor;
    private MatriculaEntity matricula;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DisciplinaEntity getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(DisciplinaEntity disciplina) {
        this.disciplina = disciplina;
    }

    public DiaLetivoEntity getDiaLetivosEntity() {
        return diaLetivosEntity;
    }

    public void setDiaLetivosEntity(DiaLetivoEntity diaLetivosEntity) {
        this.diaLetivosEntity = diaLetivosEntity;
    }

    public ProfessorEntity getProfessor() {
        return professor;
    }

    public void setProfessor(ProfessorEntity professor) {
        this.professor = professor;
    }

    public MatriculaEntity getMatricula() {
        return matricula;
    }

    public void setMatricula(MatriculaEntity matricula) {
        this.matricula = matricula;
    }
}
