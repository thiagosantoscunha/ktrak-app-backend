package br.com.ktrak.secretaria.validators;

import br.com.ktrak.Utils.AimbraFluentValidationApi.AimbraFluentApi;
import br.com.ktrak.domain.dto.in.AtualizaAlunoDto;
import br.com.ktrak.domain.dto.in.InsereAlunoDto;
import br.com.ktrak.domain.exceptions.NotFoundException;
import br.com.ktrak.domain.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AlunoValidator {

    @Autowired(required = true)
    private AimbraFluentApi validation;


    @Autowired
    private AlunoService service;

    public boolean isNaoPodeInserir(InsereAlunoDto dto) {
        return isNaoPodeSalvar(dto.nome, dto.dataNascimento, dto.logradouro, dto.cep, dto.bairro, dto.cidade, dto.estado);
    }

    public boolean isNaoPodeAtualizar(AtualizaAlunoDto dto) {
        validation.isNull(dto.id, "O aluno precisa de um Id");
        var naoPodeSalvar = isNaoPodeSalvar(dto.nome, dto.dataNascimento, dto.logradouro, dto.cep, dto.bairro, dto.cidade, dto.estado);
        var hasAluno = service.existePorId(dto.id);
        if (!hasAluno) {
            throw new NotFoundException("O usuário que você esta tentado atualizar não existe");
        }
        return naoPodeSalvar;
    }

    private boolean isNaoPodeSalvar(String nome, String dataNascimento, String logradouro, String cep, String bairro, String cidade, String estado) {
        validation.isNullOrEmpty(nome, "O nome esta nulo ou vazio");
        validation.invalidLength(nome, 10, 64, "O nome precisa ter entre 10 a 64 caracteres");
        validation.isNullOrEmpty(dataNascimento, "A data de nascimento esta nula ou vázia");
        validation.isInvalidFormat(dataNascimento, "Formato de data inválido");
        validation.isNullOrEmpty(logradouro, "O logradouro esta nulo ou vazio");
        validation.invalidLength(logradouro, 4, 64, "O logradouro precisa ter entre 4 a 64 caracteres");
        validation.isNullOrEmpty(cep, "O cep está nulo ou vazio");
        validation.invalidLength(cep, "!=", 8, "O tamanho do CEP deve ter 8 caracteres");
        validation.isNullOrEmpty(bairro, "O bairro esta nulo ou vazio");
        validation.invalidLength(bairro, 3, 64, "O bairro precisa ter entre 4 a 64 caracteres");
        validation.isNullOrEmpty(cidade, "A cidade esta nulo ou vazio");
        validation.invalidLength(cidade, 3, 64, "A cidade precisa ter entre 4 a 64 caracteres");
        validation.isNullOrEmpty(estado, "O estado esta nulo ou vazio");
        validation.invalidLength(estado, 3, 64, "O estado precisa ter entre 3 a 64 caracteres");
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
}
