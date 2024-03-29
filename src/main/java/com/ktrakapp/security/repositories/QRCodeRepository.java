package com.ktrakapp.security.repositories;

import com.ktrakapp.security.entities.QRCodeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface QRCodeRepository extends CrudRepository<QRCodeEntity, LocalDate> {

    Optional<QRCodeEntity> findDistinctFirstByCriadoEm(LocalDate criadoEm);
    boolean existsByKey(String key);

}
