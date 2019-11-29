package br.com.ktrak.domain.repositories;

import br.com.ktrak.domain.entities.RecessoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface RecessoRepository extends CrudRepository<RecessoEntity, Long> {
    boolean existsByData(LocalDate data);
}
