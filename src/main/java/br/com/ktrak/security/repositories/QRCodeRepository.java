package br.com.ktrak.security.repositories;

import br.com.ktrak.security.entities.QRCodeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface QRCodeRepository extends CrudRepository<QRCodeEntity, LocalDate> {

    Optional<QRCodeEntity> findDistinctFirstByCriadoEm(LocalDate criadoEm);
}
