package br.com.ktrak.domain.entities;

import br.com.ktrak.domain.entities.ids.MatriculaDiaLetivoId;
import br.com.ktrak.domain.entities.ids.MatriculaId;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalIdCache;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//@Entity(name = "Matricula")
//@Table(name = "matriculas")
//@NaturalIdCache
//@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class MatriculaEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

//    @EmbeddedId
//    private MatriculaId matriculaId;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @MapsId("alunoId")
//    private AlunoEntity aluno;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @MapsId("diaLetivoId")
//    private TurmaEntity turma;

//    @OneToMany
//    private List<MatriculaDiaLetitvoEntity> matriculaDiaLetitvos;

//    @Column(length = 11, unique = true, nullable = false)
//    private String numero;
//
//    @Column(nullable = false)
//    private Integer faltas;
//
//    @Column
//    private Double nota;


//
//    @OneToMany
//    private List<MatriculaDiaLetitvoEntity> matriculaDiaLetivos = new ArrayList<>();

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getNumero() {
//        return numero;
//    }
//
//    public void setNumero(String numero) {
//        this.numero = numero;
//    }
//
//    public Integer getFaltas() {
//        return faltas;
//    }
//
//    public void setFaltas(Integer faltas) {
//        this.faltas = faltas;
//    }
//
//    public Double getNota() {
//        return nota;
//    }
//
//    public void setNota(Double nota) {
//        this.nota = nota;
//    }

//    public AlunoEntity getAluno() {
//        return aluno;
//    }
//
//    public void setAluno(AlunoEntity aluno) {
//        this.aluno = aluno;
//    }
//
//    public TurmaEntity getTurma() {
//        return turma;
//    }
//
//    public void setTurma(TurmaEntity turma) {
//        this.turma = turma;
//    }

//    public List<MatriculaDiaLetitvoEntity> getMatriculaDiaLetivos() {
//        return matriculaDiaLetivos;
//    }

//    public MatriculaId getMatriculaId() {
//        return matriculaId;
//    }
//
//    public void setMatriculaId(MatriculaId matriculaId) {
//        this.matriculaId = matriculaId;
//    }

//    public List<MatriculaDiaLetitvoEntity> getMatriculaDiaLetitvos() {
//        return matriculaDiaLetitvos;
//    }
//
//    public void setMatriculaDiaLetitvos(List<MatriculaDiaLetitvoEntity> matriculaDiaLetitvos) {
//        this.matriculaDiaLetitvos = matriculaDiaLetitvos;
//    }
//
//    public void setMatriculaDiaLetivos(List<MatriculaDiaLetitvoEntity> matriculaDiaLetivos) {
//        this.matriculaDiaLetivos = matriculaDiaLetivos;
//    }
}
