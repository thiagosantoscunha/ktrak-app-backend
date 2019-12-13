package com.ktrakapp.domain.repositories;

import com.ktrakapp.domain.entities.DisciplinaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DisciplinaRepository extends CrudRepository<DisciplinaEntity, Long> {
    boolean existsByNome(String nome);

    @Query("select d from DisciplinaEntity d order by d.nome")
    List<DisciplinaEntity> findAll();
}
