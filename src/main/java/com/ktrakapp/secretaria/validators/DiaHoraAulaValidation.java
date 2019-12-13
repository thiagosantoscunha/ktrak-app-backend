package com.ktrakapp.secretaria.validators;

import com.ktrakapp.Utils.AimbraFluentValidationApi.DataValidationImpl;
import com.ktrakapp.Utils.AimbraFluentValidationApi.NumberValidationImpl;
import com.ktrakapp.Utils.AimbraFluentValidationApi.TextValidationImpl;
import com.ktrakapp.domain.dto.DiaHoraAulaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DiaHoraAulaValidation {

    @Autowired
    private TextValidationImpl textValidation;

    @Autowired
    private DataValidationImpl dataValidation;

    @Autowired
    private NumberValidationImpl numberValidation;

    public boolean isNaoPodeInserir(DiaHoraAulaDto dto) {
        textValidation.isNullOrEmpty(dto.dia, "É preciso selecionar pelo menos um dia para esta aula");
        dataValidation.isNotDayOfWeek(dto.dia, "O dia Selecionado não é um dia válido");
        textValidation.isNullOrEmpty(dto.hora, "É preciso selecionar a hora para esta aula");
        dataValidation.isInvalidHourFormat(dto.hora);
        return false;
    }

    public boolean isNaoPodeAtualizar(DiaHoraAulaDto dto) {
        numberValidation.isNull(dto.id, "Não é possível editar sem o Id do objeto DiaHoraAulaDto");
        return isNaoPodeInserir(dto);
    }

}
