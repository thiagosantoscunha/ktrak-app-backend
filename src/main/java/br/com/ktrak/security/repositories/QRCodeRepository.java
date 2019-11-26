package br.com.ktrak.security.repositories;

import br.com.ktrak.security.Entities.QRCodeEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Repository
public interface QRCodeRepository extends CrudRepository<QRCodeEntity, Long> {

    QRCodeEntity findDistinctFirstByCriadoEm(LocalDate criadoEm);
}
