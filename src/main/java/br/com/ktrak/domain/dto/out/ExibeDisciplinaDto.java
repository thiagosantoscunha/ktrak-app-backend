package br.com.ktrak.domain.dto.out;

import br.com.ktrak.domain.entities.DisciplinaEntity;
import br.com.ktrak.domain.entities.TurmaEntity;

import java.util.List;

public class ExibeDisciplinaDto {

    public Long id;
    public String nome;

    public void toDto(DisciplinaEntity entity) {
        id = entity.getId();
        nome = entity.getNome();
    }
}
