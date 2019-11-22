package br.com.ktrak.secretaria.validators;


import br.com.ktrak.Utils.AimbraFluentValidationApi.DataValidationImpl;
import br.com.ktrak.Utils.AimbraFluentValidationApi.NumberValidationImpl;
import br.com.ktrak.Utils.AimbraFluentValidationApi.TextValidationImpl;
import br.com.ktrak.domain.dto.FeriadoDto;
import br.com.ktrak.domain.exceptions.BadRequestException;
import br.com.ktrak.domain.services.FeriadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FeriadoValidation {

    @Autowired
    private FeriadoService service;

    @Autowired
    private TextValidationImpl textValidation;

    @Autowired
    private DataValidationImpl dataValidation;

    @Autowired
    private NumberValidationImpl numberValidation;

    public boolean isNaoPodeInserir(FeriadoDto dto) {

        textValidation.isNullOrEmpty(dto.data, "É preciso digitar uma data Válida para o feriado");
        dataValidation.isInvalidDateFormat(dto.data, "Data de formato inválido para o feriado");

        if (service.existePorData(dto.data)) {
            throw new BadRequestException("Este feriado já foi cadastrado");
        }

        return false;
    }

    public boolean isNaoPodeAtualizar(FeriadoDto dto) {
        numberValidation.isNull(dto.id);
        return isNaoPodeInserir(dto);
    }

}
