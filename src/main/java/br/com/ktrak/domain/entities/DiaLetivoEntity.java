package br.com.ktrak.domain.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "dias_letivos")
public class DiaLetivoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private LocalDateTime dataHora;

    @ManyToOne
    private TurmaEntity turma;

//    @OneToMany
//    private List<MatriculaDiaLetitvoEntity> matriculaDiaLetivos = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime data) {
        this.dataHora = data;
    }

    public TurmaEntity getTurma() {
        return turma;
    }

    public void setTurma(TurmaEntity turma) {
        this.turma = turma;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiaLetivoEntity that = (DiaLetivoEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(dataHora, that.dataHora) &&
                Objects.equals(turma, that.turma);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dataHora, turma);
    }
}
