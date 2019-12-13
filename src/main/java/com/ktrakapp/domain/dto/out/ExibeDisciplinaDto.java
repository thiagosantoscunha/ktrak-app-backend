package com.ktrakapp.domain.dto.out;


import com.ktrakapp.domain.entities.DisciplinaEntity;

public class ExibeDisciplinaDto {

    public Long id;
    public String nome;

    public void toDto(DisciplinaEntity entity) {
        id = entity.getId();
        nome = entity.getNome();
    }
}
