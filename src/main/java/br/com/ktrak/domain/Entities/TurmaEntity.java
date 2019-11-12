package br.com.ktrak.domain.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "turmas")
public class TurmaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    private ProfessorEntity professor;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "turma_id")
    private List<DiaLetivoEntity> diasLetivos = new ArrayList<>();

    @ManyToOne()
    @JoinColumn(name = "disciplina_id", nullable = false)
    private DisciplinaEntity disciplina;

    public List<DiaLetivoEntity> getDiasLetivos() {
        return diasLetivos;
    }

    public void setDiasLetivos(List<DiaLetivoEntity> diasLetivos) {
        this.diasLetivos = diasLetivos;
    }

    public DisciplinaEntity getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(DisciplinaEntity disciplina) {
        this.disciplina = disciplina;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProfessorEntity getProfessor() {
        return professor;
    }

    public void setProfessor(ProfessorEntity professor) {
        this.professor = professor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TurmaEntity that = (TurmaEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(professor, that.professor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, professor);
    }
}
