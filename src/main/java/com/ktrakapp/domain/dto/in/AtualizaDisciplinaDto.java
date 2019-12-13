package com.ktrakapp.domain.dto.in;


import com.ktrakapp.domain.entities.DisciplinaEntity;

public class AtualizaDisciplinaDto {
    public Long id;
    public String nome;

    public DisciplinaEntity toEntity() {
        DisciplinaEntity entity = new DisciplinaEntity();
        entity.setId(id);
        entity.setNome(nome);
        return entity;
    }
}
