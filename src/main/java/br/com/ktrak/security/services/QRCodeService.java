package br.com.ktrak.security.services;

import br.com.ktrak.Utils.Utils;
import br.com.ktrak.domain.converters.QRCodeConverter;
import br.com.ktrak.security.Entities.QRCodeEntity;
import br.com.ktrak.security.dto.QRCodeDto;
import br.com.ktrak.security.repositories.QRCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

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

    public QRCodeDto buscaPorDataMaisRecente() {
        return converter.toDto(repository.findDistinctFirstByCriadoEm(LocalDate.now()));
    }

    public List<QRCodeDto> buscaTudo() {
        return converter.toDtoList(repository.findAll());
    }
}
