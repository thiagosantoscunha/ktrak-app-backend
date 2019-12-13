package com.ktrakapp.domain.repositories;

import com.ktrakapp.domain.entities.RecessoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface RecessoRepository extends CrudRepository<RecessoEntity, Long> {
    boolean existsByData(LocalDate data);
}
