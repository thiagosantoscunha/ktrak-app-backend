package br.com.ktrak.secretaria.validators;

import br.com.ktrak.Utils.AimbraFluentValidationApi.DataValidationImpl;
import br.com.ktrak.Utils.AimbraFluentValidationApi.NumberValidationImpl;
import br.com.ktrak.Utils.AimbraFluentValidationApi.TextValidationImpl;
import br.com.ktrak.Utils.LocalFormatter;
import br.com.ktrak.domain.dto.SemestreDto;
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

    public boolean isNaoPodeInserir(SemestreDto dto) {
        textValidation.isNullOrEmpty(dto.dataInicio, "É preciso selecionar uma data de inicio");
        dataValidation.isInvalidDateFormat(dto.dataInicio);
        textValidation.isNullOrEmpty(dto.dataFim, "É preciso selecionar uma data de fim");
        dataValidation.isInvalidDateFormat(dto.dataFim);
        dataValidation.isInvalidRange(LocalFormatter.toLocalDate(dto.dataInicio), LocalFormatter.toLocalDate(dto.dataFim), "A data do fim de semestre não pode ser maior que a data de inicio");
        return false;
    }

    public boolean isNaoPodeAtualizar(SemestreDto dto) {
        numberValidation.isNull(dto.id, "Não encontramos o Id deste semestre");
        return isNaoPodeInserir(dto);
    }

}
