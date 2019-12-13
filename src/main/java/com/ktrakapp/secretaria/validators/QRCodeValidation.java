package com.ktrakapp.secretaria.validators;


import com.ktrakapp.domain.exceptions.BadRequestException;
import com.ktrakapp.security.dto.QRCodeDto;
import com.ktrakapp.security.services.QRCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class QRCodeValidation {

    @Autowired
    private QRCodeService service;

    public boolean isNaoPodeGerar() {
        if (jaGerouHoje()) throw new BadRequestException("Já tem uma chave", new Throwable("201901"));
        return false;
    }

    private boolean jaGerouHoje() {
        QRCodeDto qrCodeDto = service.buscaPorDataRecente();
        if (qrCodeDto != null) {
            return qrCodeDto.getCriadoEm().isEqual(LocalDate.now());
        }
        return false;
    }

}
