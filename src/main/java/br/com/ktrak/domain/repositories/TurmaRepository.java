package br.com.ktrak.domain.repositories;

import br.com.ktrak.domain.entities.TurmaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaRepository extends CrudRepository<TurmaEntity, Long> {
}
