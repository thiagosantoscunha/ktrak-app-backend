package com.ktrakapp.secretaria.validators;


import com.ktrakapp.Utils.AimbraFluentValidationApi.DataValidationImpl;
import com.ktrakapp.Utils.AimbraFluentValidationApi.NumberValidationImpl;
import com.ktrakapp.Utils.AimbraFluentValidationApi.TextValidationImpl;
import com.ktrakapp.Utils.LocalFormatter;
import com.ktrakapp.domain.dto.SemestreDto;
import com.ktrakapp.domain.exceptions.BadRequestException;
import com.ktrakapp.domain.services.SemestreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SemestreValidation {

    @Autowired
    private TextValidationImpl textValidation;

    @Autowired
    private DataValidationImpl dataValidation;

    @Autowired
    private NumberValidationImpl numberValidation;

    @Autowired
    private SemestreService service;

    public boolean isNaoPodeInserir(SemestreDto dto) {
        textValidation.isNullOrEmpty(dto.dataInicio, "É preciso selecionar uma data de inicio");
        dataValidation.isInvalidDateFormat(dto.dataInicio);
        textValidation.isNullOrEmpty(dto.dataFim, "É preciso selecionar uma data de fim");
        dataValidation.isInvalidDateFormat(dto.dataFim);
        dataValidation.isInvalidRange(LocalFormatter.toLocalDate(dto.dataInicio), LocalFormatter.toLocalDate(dto.dataFim), "A data do fim de semestre não pode ser maior que a data de inicio");
        if (service.existePorDataInicioAndFim(dto.dataInicio, dto.dataFim)) {
            throw new BadRequestException("Já existe um semestre com esta data cadastrada");
        }
        return false;
    }

    public boolean isNaoPodeAtualizar(SemestreDto dto) {
        numberValidation.isNull(dto.id, "Não encontramos o Id deste semestre");
        return isNaoPodeInserir(dto);
    }

}
