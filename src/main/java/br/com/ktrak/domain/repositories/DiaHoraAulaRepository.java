package br.com.ktrak.domain.repositories;

import br.com.ktrak.domain.entities.DiaHoraAulaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiaHoraAulaRepository extends CrudRepository<DiaHoraAulaEntity, Long> {
    boolean existsByDiaAndHora(String dia, String hora);
}
