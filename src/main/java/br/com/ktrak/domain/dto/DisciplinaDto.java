package br.com.ktrak.domain.dto;

import br.com.ktrak.domain.dto.interfaces.OnCreate;
import br.com.ktrak.domain.dto.interfaces.OnUpdate;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

public class DisciplinaDto {

    public Long id;
    public String nome;

    public DisciplinaDto() {
    }

    public DisciplinaDto(String nome) {
        this.nome = nome;
    }

    public DisciplinaDto(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

}
