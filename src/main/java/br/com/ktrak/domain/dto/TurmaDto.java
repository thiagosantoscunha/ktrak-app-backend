package br.com.ktrak.domain.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class TurmaDto {

    private Long id;
    private ProfessorDto professor;
    private DisciplinaDto disciplina;
    private List<DiaHoraAulaDto> diaHoraAulas;



    public TurmaDto() {
    }

    public TurmaDto(Long id, ProfessorDto professor, DisciplinaDto disciplina) {
        this.id = id;
        this.professor = professor;
        this.disciplina = disciplina;
    }

    public TurmaDto(Long id, ProfessorDto professor, DisciplinaDto disciplina, List<DiaHoraAulaDto> diaHoraAulas) {
        this.id = id;
        this.professor = professor;
        this.disciplina = disciplina;
        this.diaHoraAulas = diaHoraAulas;
    }

}
