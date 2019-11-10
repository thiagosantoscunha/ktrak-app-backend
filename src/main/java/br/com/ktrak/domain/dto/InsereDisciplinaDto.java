package br.com.ktrak.domain.dto;

import br.com.ktrak.domain.entities.DisciplinaEntity;

public class InsereDisciplinaDto {
    public String nome;

    public DisciplinaEntity toEntity() {
        var entity = new DisciplinaEntity();
        entity.setNome(nome);
        return entity;
    }
}
