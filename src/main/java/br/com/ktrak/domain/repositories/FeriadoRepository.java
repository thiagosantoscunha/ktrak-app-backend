package br.com.ktrak.domain.repositories;

import br.com.ktrak.domain.entities.FeriadoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface FeriadoRepository extends CrudRepository<FeriadoEntity, Long> {
    boolean existsByData(LocalDate data);
}
