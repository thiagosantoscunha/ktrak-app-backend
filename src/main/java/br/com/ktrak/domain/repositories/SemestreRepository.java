package br.com.ktrak.domain.repositories;

import br.com.ktrak.domain.entities.SemestreEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SemestreRepository extends CrudRepository<SemestreEntity, Long> {
}
