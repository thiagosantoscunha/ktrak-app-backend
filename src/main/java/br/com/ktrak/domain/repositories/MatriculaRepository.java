package br.com.ktrak.domain.repositories;

import br.com.ktrak.domain.entities.AlunoEntity;
import br.com.ktrak.domain.entities.MatriculaEntity;
import br.com.ktrak.domain.entities.TurmaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MatriculaRepository extends CrudRepository<MatriculaEntity, Long> {
    boolean existsByAlunoAndTurma(AlunoEntity aluno, TurmaEntity turmaEntity);
    Optional<List<MatriculaEntity>> findAllByAluno(AlunoEntity toEntity);

    @Query(value = "select * from matriculas m join turmas t on m.turma_id = t.id join disciplinas d on t.disciplina_id = d.id where d.nome = :nomeCurso", nativeQuery = true)
    List<MatriculaEntity> findAllByNomeCurso(@Param("nomeCurso") String nomeCurso);
}
