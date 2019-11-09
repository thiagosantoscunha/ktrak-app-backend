package br.com.ktrak.domain.repositories;

import br.com.ktrak.domain.entities.AlunoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends CrudRepository<AlunoEntity, Long> {
}
