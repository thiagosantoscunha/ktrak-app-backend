package com.ktrakapp.domain.repositories;

import com.ktrakapp.domain.entities.DiaLetivoEntity;
import com.ktrakapp.domain.entities.TurmaEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DiaLetivoRepository extends CrudRepository<DiaLetivoEntity, Long> {
    List<DiaLetivoEntity> findAllByTurma(TurmaEntity turma);
}
