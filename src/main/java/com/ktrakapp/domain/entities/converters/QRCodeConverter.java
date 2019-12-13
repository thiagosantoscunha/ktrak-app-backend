package com.ktrakapp.domain.entities.converters;

import com.ktrakapp.security.dto.QRCodeDto;
import com.ktrakapp.security.entities.QRCodeEntity;
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
