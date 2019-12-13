package com.ktrakapp.domain.repositories;

import com.ktrakapp.domain.entities.AlunoEntity;
import com.ktrakapp.domain.entities.TurmaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TurmaRepository extends CrudRepository<TurmaEntity, Long> {
    @Query("select t from TurmaEntity t join MatriculaEntity m on m.turma = t join AlunoEntity a on m.aluno = a where m.aluno = :aluno")
    List<TurmaEntity> findAllbyAluno(@Param("aluno") AlunoEntity aluno);
}
