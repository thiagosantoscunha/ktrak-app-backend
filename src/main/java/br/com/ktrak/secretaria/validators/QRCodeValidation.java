package br.com.ktrak.secretaria.validators;


import br.com.ktrak.domain.exceptions.BadRequestException;
import br.com.ktrak.domain.exceptions.QrCodeGenerateException;
import br.com.ktrak.security.dto.QRCodeDto;
import br.com.ktrak.security.services.QRCodeService;
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
