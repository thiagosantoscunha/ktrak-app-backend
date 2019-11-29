package br.com.ktrak.domain.converters;

import br.com.ktrak.security.entities.QRCodeEntity;
import br.com.ktrak.security.dto.QRCodeDto;
import org.springframework.stereotype.Service;

@Service
public class QRCodeConverter extends Converter<QRCodeDto, QRCodeEntity> {
    public QRCodeConverter() {
        super(fromDto -> {
            QRCodeEntity entity = new QRCodeEntity();
            entity.setKey(fromDto.getKey());
            return entity;
        }, fromEntity -> {
            QRCodeDto dto = new QRCodeDto();
            dto.setKey(fromEntity.getKey());
            dto.setCriadoEm(fromEntity.getCriadoEm());
            return dto;
        });
    }
}
