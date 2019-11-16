package br.com.ktrak.domain.repositories;

import br.com.ktrak.domain.entities.MatriculaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatriculaRepository extends CrudRepository<MatriculaEntity, Long> {
}
