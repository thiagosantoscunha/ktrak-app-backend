package br.com.ktrak.domain.repositories;

import br.com.ktrak.domain.entities.PresenciamentoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PresenciamentoRepository extends CrudRepository<PresenciamentoEntity, Long> {
}
