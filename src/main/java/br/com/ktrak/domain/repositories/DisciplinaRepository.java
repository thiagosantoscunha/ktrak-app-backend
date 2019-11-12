package br.com.ktrak.domain.repositories;

import br.com.ktrak.domain.entities.DisciplinaEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DisciplinaRepository extends CrudRepository<DisciplinaEntity, Long> {
    boolean existsByNome(String nome);
}
