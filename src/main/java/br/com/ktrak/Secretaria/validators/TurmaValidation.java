package br.com.ktrak.Secretaria.validators;

import br.com.ktrak.Utils.AimbraFluentValidationApi.AimbraFluentApi;
import br.com.ktrak.Utils.AimbraFluentValidationApi.NumberValidationImpl;
import br.com.ktrak.Utils.AimbraFluentValidationApi.ObjectValidationImpl;
import br.com.ktrak.domain.dto.in.InsereTurmaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TurmaValidation {

    @Autowired
    private ObjectValidationImpl validation;

    public void isNaoPodeInserir(InsereTurmaDto dto) {
        validation.isNotNull(dto.professor, "É preciso selecionar um professor para a turma");
    }

}
