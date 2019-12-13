package com.ktrakapp.domain.repositories;

import com.ktrakapp.domain.entities.SemestreEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface SemestreRepository extends CrudRepository<SemestreEntity, Long> {
    boolean existsByDataInicioAndDataFim(LocalDate dataInicio, LocalDate dataFim);
}
