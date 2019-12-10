package br.com.ktrak.mobile.validators;

import br.com.ktrak.Utils.AimbraFluentValidationApi.TextValidationImpl;
import br.com.ktrak.domain.dto.MarcaPresencaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MarcaPresencaValidation {

    @Autowired
    private TextValidationImpl textValidation;

    public boolean isNaoPodeMarcarPresenca(MarcaPresencaDto dto) {

        textValidation.isNullOrEmpty(dto.getUsername(), "Aluno esta vazio");
        textValidation.isNullOrEmpty(dto.getKey(), "A chave esta vazia");

        return false;
    }


}
