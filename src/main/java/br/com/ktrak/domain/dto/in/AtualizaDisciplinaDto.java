package br.com.ktrak.domain.dto.in;

import br.com.ktrak.domain.entities.DisciplinaEntity;

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
