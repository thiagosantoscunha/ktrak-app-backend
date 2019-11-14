package br.com.ktrak.domain.dto;

public class TurmaDto {

    public Long id;
    public ProfessorDto professor;
    public DisciplinaDto disciplina;

    public TurmaDto() {
    }

    public TurmaDto(ProfessorDto professor, DisciplinaDto disciplina) {
        this.professor = professor;
        this.disciplina = disciplina;
    }

    public TurmaDto(Long id, ProfessorDto professor, DisciplinaDto disciplina) {
        this.id = id;
        this.professor = professor;
        this.disciplina = disciplina;
    }

}
