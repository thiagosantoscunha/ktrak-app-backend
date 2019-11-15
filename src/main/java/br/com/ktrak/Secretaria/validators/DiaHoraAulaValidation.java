package br.com.ktrak.secretaria.validators;

import br.com.ktrak.Utils.AimbraFluentValidationApi.DataValidationImpl;
import br.com.ktrak.Utils.AimbraFluentValidationApi.NumberValidationImpl;
import br.com.ktrak.Utils.AimbraFluentValidationApi.TextValidationImpl;
import br.com.ktrak.domain.dto.DiaHoraAulaDto;
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
        textValidation.invalidLength(dto.dia, 6, 9, "O dia precisa ter entre 6 a 9 caracteres");
        textValidation.isNullOrEmpty(dto.hora, "É preciso selecionar a hora para esta aula");
        dataValidation.isInvalidDateFormat(dto.hora);
        return false;
    }

    public boolean isNaoPodeAtualizar(DiaHoraAulaDto dto) {
        numberValidation.isNull(dto.id, "Não é possível editar sem o Id do objeto DiaHoraAulaDto");
        return isNaoPodeInserir(dto);
    }

}
