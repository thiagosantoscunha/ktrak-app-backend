package br.com.ktrak.domain.repositories;

import br.com.ktrak.domain.entities.PessoaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends CrudRepository<PessoaEntity, Long> {
}
