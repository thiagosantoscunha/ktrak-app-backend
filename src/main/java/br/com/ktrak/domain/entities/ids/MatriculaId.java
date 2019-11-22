package br.com.ktrak.domain.entities.ids;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
@EqualsAndHashCode
public class MatriculaId implements Serializable {

    private static final long serialVersionUID = -3138856182021663633L;

    @Column(name = "aluno_id")
    private Long aluno;

    @Column(name = "turma_id")
    private Long turma;

//    public MatriculaId() {
//    }
//
//    public MatriculaId(Long aluno, Long turma) {
//        this.aluno = aluno;
//        this.turma = turma;
//    }


}
