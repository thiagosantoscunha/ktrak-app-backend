package br.com.ktrak.domain.repositories;

import br.com.ktrak.domain.entities.DiaLetivoEntity;
import br.com.ktrak.domain.entities.TurmaEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DiaLetivoRepository extends CrudRepository<DiaLetivoEntity, Long> {
    List<DiaLetivoEntity> findAllByTurma(TurmaEntity turma);
}
