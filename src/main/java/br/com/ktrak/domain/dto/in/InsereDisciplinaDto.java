package br.com.ktrak.domain.dto.in;

import br.com.ktrak.domain.entities.DisciplinaEntity;

public class InsereDisciplinaDto {
    public String nome;

    public DisciplinaEntity toEntity() {
        DisciplinaEntity entity = new DisciplinaEntity();
        entity.setNome(nome);
        return entity;
    }
}
