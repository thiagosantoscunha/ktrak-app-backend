package com.ktrakapp.secretaria.validators;

import com.ktrakapp.Utils.AimbraFluentValidationApi.DataValidationImpl;
import com.ktrakapp.Utils.AimbraFluentValidationApi.NumberValidationImpl;
import com.ktrakapp.Utils.AimbraFluentValidationApi.TextValidationImpl;
import com.ktrakapp.domain.dto.RecessoDto;
import com.ktrakapp.domain.exceptions.BadRequestException;
import com.ktrakapp.domain.services.RecessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RecessoValidation {

    @Autowired
    private RecessoService service;

    @Autowired
    private TextValidationImpl textValidation;

    @Autowired
    private DataValidationImpl dataValidation;

    @Autowired
    private NumberValidationImpl numberValidation;

    public boolean isNaoPodeInserir(RecessoDto dto) {

        textValidation.isNullOrEmpty(dto.data, "É preciso digitar uma data Válida para o feriado");
        dataValidation.isInvalidDateFormat(dto.data, "Data de formato inválido para o feriado");

        if (service.existePorData(dto.data)) {
            throw new BadRequestException("Este feriado já foi cadastrado");
        }

        return false;
    }

    public boolean isNaoPodeAtualizar(RecessoDto dto) {
        numberValidation.isNull(dto.id);
        return isNaoPodeInserir(dto);
    }

}
