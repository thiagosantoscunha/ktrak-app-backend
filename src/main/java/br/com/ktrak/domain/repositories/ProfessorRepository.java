package br.com.ktrak.domain.repositories;

import br.com.ktrak.domain.entities.AlunoEntity;
import br.com.ktrak.domain.entities.ProfessorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorRepository extends CrudRepository<ProfessorEntity, Long> {
    List<ProfessorEntity> findAllByOrderByNomeAsc();
}
