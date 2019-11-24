package br.com.ktrak.domain.repositories;

import br.com.ktrak.domain.entities.AlunoEntity;
import br.com.ktrak.domain.entities.TurmaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends CrudRepository<AlunoEntity, Long> {
    List<AlunoEntity> findAllByOrderByNomeAsc();
}
