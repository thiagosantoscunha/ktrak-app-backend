package com.ktrakapp.security.services;

import com.ktrakapp.Utils.Utils;
import com.ktrakapp.domain.entities.converters.QRCodeConverter;
import com.ktrakapp.security.dto.QRCodeDto;
import com.ktrakapp.security.entities.QRCodeEntity;
import com.ktrakapp.security.repositories.QRCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class QRCodeService {

    @Autowired
    private QRCodeRepository repository;

    @Autowired
    private QRCodeConverter converter;

    public QRCodeDto generate() {
        QRCodeEntity entity = new QRCodeEntity();
        String value = Utils
                .encodePassword(LocalDateTime.now().toString())
                .trim()
                .replaceAll("[^a-zA-Z]+","")
                .substring(0, 4);
        entity.setKey(value);
        entity.setCriadoEm(LocalDate.now());
        return converter.toDto(repository.save(entity));
    }

    public QRCodeDto buscaPorDataRecente() {
        Optional<QRCodeEntity> response = repository.findDistinctFirstByCriadoEm(LocalDate.now());
        return response.map(qrCodeEntity -> converter.toDto(qrCodeEntity)).orElse(null);
    }

    public List<QRCodeDto> buscaTudo() {
        return converter.toDtoList(repository.findAll());
    }

    public boolean existePorKey(String key) {
        return repository.existsByKey(key);
    }
}
