package br.com.ktrak.secretaria.validators;

import br.com.ktrak.Utils.AimbraFluentValidationApi.AimbraFluentApi;
import br.com.ktrak.domain.dto.in.InsereTurmaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TurmaValidation {

    @Autowired
    private AimbraFluentApi validation;

    public void isNaoPodeInserir(InsereTurmaDto dto) {
        validation.isNotNull(dto.professor, "É preciso selecionar um professor para a turma");
    }

}
