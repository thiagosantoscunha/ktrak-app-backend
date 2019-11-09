package br.com.ktrak.secretaria.validators;

import br.com.ktrak.Utils.DataValidationService;
import br.com.ktrak.Utils.TextValidationService;
import br.com.ktrak.domain.dto.InsereProfessorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProfessorValidator {

    @Autowired
    private TextValidationService textValidation;

    @Autowired
    private DataValidationService dataValidation;

    public boolean isNaoPodeInserir(InsereProfessorDto dto) {
        textValidation.isNullOrEmpty(dto.nome, "O nome do professor não pode ser nulo ou vazio");
        textValidation.invalidLength(dto.nome, 10, 64, "O nome precisa ter entre 10 a 64 caracteres");
        textValidation.isNullOrEmpty(dto.dataNascimento, "A data de nascimento esta nula ou vázia");
        dataValidation.isInvalidFormat(dto.dataNascimento, "O formato da data é inválido.");
        textValidation.isNullOrEmpty(dto.logradouro, "O logradouro esta nulo ou vazio");
        textValidation.invalidLength(dto.logradouro, 4, 64, "O logradouro precisa ter entre 4 a 64 caracteres");
        textValidation.isNullOrEmpty(dto.cep, "O cep está nulo ou vazio");
        textValidation.invalidLength(dto.cep, "!=", 8, "O tamanho do CEP deve ter 8 caracteres");
        textValidation.isNullOrEmpty(dto.bairro, "O bairro esta nulo ou vazio");
        textValidation.invalidLength(dto.bairro, 3, 64, "O bairro precisa ter entre 4 a 64 caracteres");
        textValidation.isNullOrEmpty(dto.cidade, "A cidade esta nulo ou vazio");
        textValidation.invalidLength(dto.cidade, 3, 64, "A cidade precisa ter entre 4 a 64 caracteres");
        textValidation.isNullOrEmpty(dto.estado, "O estado esta nulo ou vazio");
        textValidation.invalidLength(dto.estado, 3, 64, "O estado precisa ter entre 3 a 64 caracteres");
        return false;
    }

}
