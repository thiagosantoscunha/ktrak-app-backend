package br.com.ktrak.secretaria.validators;

import br.com.ktrak.Utils.AimbraFluentValidationApi.DataValidationImpl;
import br.com.ktrak.Utils.AimbraFluentValidationApi.NumberValidationImpl;
import br.com.ktrak.Utils.AimbraFluentValidationApi.TextValidationImpl;
import br.com.ktrak.domain.dto.AlunoDto;
import br.com.ktrak.domain.exceptions.NotFoundException;
import br.com.ktrak.domain.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AlunoValidator {

    @Autowired
    private AlunoService service;

    @Autowired
    TextValidationImpl textValidation;

    @Autowired
    NumberValidationImpl numberValidation;

    @Autowired
    DataValidationImpl dataValidation;

    public boolean isNaoPodeInserir(AlunoDto dto) {
        return isNaoPodeSalvar(dto.getNome(), dto.getDataNascimento(), dto.getLogradouro(), dto.getCep(), dto.getBairro(), dto.getCidade(), dto.getEstado());
    }

    public boolean isNaoPodeAtualizar(AlunoDto dto) {
        numberValidation.isNull(dto.getId(), "O aluno precisa de um Id");
        var naoPodeSalvar = isNaoPodeSalvar(dto.getNome(), dto.getDataNascimento(), dto.getLogradouro(), dto.getCep(), dto.getBairro(), dto.getCidade(), dto.getEstado());
        var hasAluno = service.existePorId(dto.getId());
        if (!hasAluno) {
            throw new NotFoundException("O usuário que você esta tentado atualizar não existe");
        }
        return naoPodeSalvar;
    }

    private boolean isNaoPodeSalvar(String nome, String dataNascimento, String logradouro, String cep, String bairro, String cidade, String estado) {
        textValidation.isNullOrEmpty(nome, "O nome esta nulo ou vazio");
        textValidation.invalidLength(nome, 10, 64, "O nome precisa ter entre 10 a 64 caracteres");
        textValidation.isNullOrEmpty(dataNascimento, "A data de nascimento esta nula ou vázia");
        dataValidation.isInvalidDateFormat(dataNascimento, "Formato de data inválido");
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

    public boolean isNaoPodeBuscarPorId(Long id) {
        var hasAluno = service.existePorId(id);
        if (!hasAluno) throw new NotFoundException("Este aluno não esta cadastrado em nossa base de dados");
        return false;
    }

    public boolean isNaoPodeRemover(Long id) {
        var hasAluno = service.existePorId(id);
        if (!hasAluno) throw new NotFoundException("Este aluno não esta cadastrado em nossa base de dados");
        return false;
    }

    public boolean isNaoPodeBuscarPorNome(String nome) {
        textValidation.isNullOrEmpty(nome, "O campo de busca esta vazio");
        textValidation.invalidLength(nome, 3, 64, "O campo de busca precisa ter entre 3 a 64 caracteres");
        return false;
    }
}
