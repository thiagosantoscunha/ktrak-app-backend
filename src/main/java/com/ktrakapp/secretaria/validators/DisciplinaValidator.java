package com.ktrakapp.secretaria.validators;

import com.ktrakapp.Utils.AimbraFluentValidationApi.NumberValidationImpl;
import com.ktrakapp.Utils.AimbraFluentValidationApi.TextValidationImpl;
import com.ktrakapp.domain.dto.DisciplinaDto;
import com.ktrakapp.domain.exceptions.BadRequestException;
import com.ktrakapp.domain.services.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DisciplinaValidator {

    @Autowired
    private DisciplinaService service;

    @Autowired
    private TextValidationImpl textValidation;

    @Autowired
    private NumberValidationImpl numberValidation;



    public boolean isNaoPodeInserir(DisciplinaDto dto) {
        return isNaoPodeSalvar(dto.nome);
    }

    public boolean isNaoPodeAtualizar(DisciplinaDto model) {
        return isNaoPodeBuscarPorId(model.id) || isNaoPodeSalvar(model.nome);
    }

    private boolean isNaoPodeSalvar(String nome) {
        textValidation.isNullOrEmpty(nome, "A discplina precisa ter um nome");
        textValidation.invalidLength(nome, 3, 64, "O nome da disciplina precisa ter entre 3 a 64 caracteres");
        if (service.existePorNome(nome)) {
            throw new BadRequestException("Já existe uma disciplina com este nome.");
        }
        return false;
    }

    public boolean isNaoPodeBuscarPorId(Long id) {
        numberValidation.isNull(id, "É preciso um Id válido para disciplina");
        if (!service.existePorId(id)) {
            throw new BadRequestException("Não existe esta disciplina");
        }
        return false;
    }

    public boolean isNaoPodeRemover(Long id) {
        return isNaoPodeBuscarPorId(id);
    }


}
