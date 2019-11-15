package br.com.ktrak.domain.dto;

import java.util.List;

public class TurmaDto {

    public Long id;
    public ProfessorDto professor;
    public DisciplinaDto disciplina;
    public List<DiaHoraAulaDto> diaHoraAulas;

    public TurmaDto() {
    }

    public TurmaDto(Long id, ProfessorDto professor, DisciplinaDto disciplina, List<DiaHoraAulaDto> diaHoraAulas) {
        this.id = id;
        this.professor = professor;
        this.disciplina = disciplina;
        this.diaHoraAulas = diaHoraAulas;
    }

}
