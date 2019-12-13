package com.ktrakapp.domain.repositories;

import com.ktrakapp.domain.entities.ProfessorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorRepository extends CrudRepository<ProfessorEntity, Long> {
    List<ProfessorEntity> findAllByOrderByNomeAsc();
}
