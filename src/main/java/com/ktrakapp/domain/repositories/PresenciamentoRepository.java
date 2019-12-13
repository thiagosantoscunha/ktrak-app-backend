package com.ktrakapp.domain.repositories;

import com.ktrakapp.domain.entities.PresenciamentoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PresenciamentoRepository extends CrudRepository<PresenciamentoEntity, Long> {
}
