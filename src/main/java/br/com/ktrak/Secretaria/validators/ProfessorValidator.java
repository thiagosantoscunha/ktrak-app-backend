package br.com.ktrak.secretaria.validators;

import br.com.ktrak.Utils.DataValidationService;
import br.com.ktrak.Utils.NumberValidationServiceImpl;
import br.com.ktrak.Utils.TextValidationService;
import br.com.ktrak.domain.dto.AtualizaProfessorDto;
import br.com.ktrak.domain.dto.InsereProfessorDto;
import br.com.ktrak.domain.exceptions.NotFoundException;
import br.com.ktrak.domain.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProfessorValidator {

    @Autowired
    private TextValidationService textValidation;

    @Autowired
    private DataValidationService dataValidation;

    @Autowired
    NumberValidationServiceImpl numberValidationService;

    @Autowired
    private ProfessorService service;

    public boolean isNaoPodeInserir(InsereProfessorDto dto) {
        return isNaoPodeSalvar(dto.nome, dto.dataNascimento, dto.logradouro, dto.cep, dto.bairro, dto.cidade, dto.estado);
    }

    private boolean isNaoPodeSalvar(String nome, String dataNascimento, String logradouro, String cep, String bairro, String cidade, String estado) {
        textValidation.isNullOrEmpty(nome, "O nome do professor não pode ser nulo ou vazio");
        textValidation.invalidLength(nome, 10, 64, "O nome precisa ter entre 10 a 64 caracteres");
        textValidation.isNullOrEmpty(dataNascimento, "A data de nascimento esta nula ou vázia");
        dataValidation.isInvalidFormat(dataNascimento, "O formato da data é inválido.");
        textValidation.isNullOrEmpty(logradouro, "O logradouro esta nulo ou vazio");
        textValidation.invalidLength(logradouro, 4, 64, "O logradouro precisa ter entre 4 a 64 caracteres");
        textValidation.isNullOrEmpty(cep, "O cep está nulo ou vazio");
        textValidation.invalidLength(cep, "!=", 8, "O tamanho do CEP deve ter 8 caracteres");
        textValidation.isNullOrEmpty(bairro, "O bairro esta nulo ou vazio");
        textValidation.invalidLength(bairro, 3, 64, "O bairro precisa ter entre 4 a 64 caracteres");
        textValidation.isNullOrEmpty(cidade, "A cidade esta nulo ou vazio");
        textValidation.invalidLength(cidade, 3, 64, "A cidade precisa ter entre 4 a 64 caracteres");
        textValidation.isNullOrEmpty(estado, "O estado esta nulo ou vazio");
        textValidation.invalidLength(estado, 3, 64, "O estado precisa ter entre 3 a 64 caracteres");
        return false;
    }

    public boolean naoPodeBuscar(Long id) {
        numberValidationService.isNull(id);
        if (!service.existePorId(id)) {
            throw new NotFoundException("Não encontramos este professor na base de dados");
        }
        return false;
    }

    public boolean isNaoPodeAtualizar(AtualizaProfessorDto dto) {
        numberValidationService.isNull(dto.id);
        var naoPodeSalvar = isNaoPodeSalvar(dto.nome, dto.dataNascimento, dto.logradouro, dto.cep, dto.bairro, dto.cidade, dto.estado);
        if (!service.existePorId(dto.id)) {
            throw new NotFoundException("Não encontramos este professor na base de dados");
        }
        return naoPodeSalvar;
    }

    public boolean isNaoPodeRemover(Long id) {
        numberValidationService.isNull(id);
        if (!service.existePorId(id)) {
            throw new NotFoundException("Não encontramos este professor na base de dados");
        }
        return false;
    }
}