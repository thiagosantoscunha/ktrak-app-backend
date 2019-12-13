package com.ktrakapp.domain.dto.in;

import com.ktrakapp.domain.entities.DisciplinaEntity;

public class InsereDisciplinaDto {
    public String nome;

    public DisciplinaEntity toEntity() {
        DisciplinaEntity entity = new DisciplinaEntity();
        entity.setNome(nome);
        return entity;
    }
}
