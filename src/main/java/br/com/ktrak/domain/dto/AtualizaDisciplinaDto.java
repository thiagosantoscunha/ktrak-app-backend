package br.com.ktrak.domain.dto;

import br.com.ktrak.domain.entities.DisciplinaEntity;

public class AtualizaDisciplinaDto {
    public Long id;
    public String nome;

    public DisciplinaEntity toEntity() {
        var entity = new DisciplinaEntity();
        entity.setId(id);
        entity.setNome(nome);
        return entity;
    }
}
