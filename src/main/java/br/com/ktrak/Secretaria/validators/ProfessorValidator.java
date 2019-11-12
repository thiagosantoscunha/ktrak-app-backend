package br.com.ktrak.secretaria.validators;

import br.com.ktrak.Utils.AimbraFluentValidationApi.AimbraFluentApi;
import br.com.ktrak.domain.dto.in.AtualizaProfessorDto;
import br.com.ktrak.domain.dto.in.InsereProfessorDto;
import br.com.ktrak.domain.exceptions.NotFoundException;
import br.com.ktrak.domain.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProfessorValidator {

    @Autowired
    private AimbraFluentApi fluent;


    @Autowired
    private ProfessorService service;

    public boolean isNaoPodeInserir(InsereProfessorDto dto) {
        return isNaoPodeSalvar(dto.nome, dto.dataNascimento, dto.logradouro, dto.cep, dto.bairro, dto.cidade, dto.estado);
    }

    private boolean isNaoPodeSalvar(String nome, String dataNascimento, String logradouro, String cep, String bairro, String cidade, String estado) {
        fluent.isNullOrEmpty(nome, "O nome do professor não pode ser nulo ou vazio");
        fluent.invalidLength(nome, 10, 64, "O nome precisa ter entre 10 a 64 caracteres");
        fluent.isNullOrEmpty(dataNascimento, "A data de nascimento esta nula ou vázia");
        fluent.isInvalidFormat(dataNascimento, "O formato da data é inválido.");
        fluent.isNullOrEmpty(logradouro, "O logradouro esta nulo ou vazio");
        fluent.invalidLength(logradouro, 4, 64, "O logradouro precisa ter entre 4 a 64 caracteres");
        fluent.isNullOrEmpty(cep, "O cep está nulo ou vazio");
        fluent.invalidLength(cep, "!=", 8, "O tamanho do CEP deve ter 8 caracteres");
        fluent.isNullOrEmpty(bairro, "O bairro esta nulo ou vazio");
        fluent.invalidLength(bairro, 3, 64, "O bairro precisa ter entre 4 a 64 caracteres");
        fluent.isNullOrEmpty(cidade, "A cidade esta nulo ou vazio");
        fluent.invalidLength(cidade, 3, 64, "A cidade precisa ter entre 4 a 64 caracteres");
        fluent.isNullOrEmpty(estado, "O estado esta nulo ou vazio");
        fluent.invalidLength(estado, 3, 64, "O estado precisa ter entre 3 a 64 caracteres");
        return false;
    }

    public boolean naoPodeBuscar(Long id) {
        fluent.isNull(id);
        if (!service.existePorId(id)) {
            throw new NotFoundException("Não encontramos este professor na base de dados");
        }
        return false;
    }

    public boolean isNaoPodeAtualizar(AtualizaProfessorDto dto) {
        fluent.isNull(dto.id);
        var naoPodeSalvar = isNaoPodeSalvar(dto.nome, dto.dataNascimento, dto.logradouro, dto.cep, dto.bairro, dto.cidade, dto.estado);
        if (!service.existePorId(dto.id)) {
            throw new NotFoundException("Não encontramos este professor na base de dados");
        }
        return naoPodeSalvar;
    }

    public boolean isNaoPodeRemover(Long id) {
        fluent.isNull(id);
        if (!service.existePorId(id)) {
            throw new NotFoundException("Não encontramos este professor na base de dados");
        }
        return false;
    }
}
