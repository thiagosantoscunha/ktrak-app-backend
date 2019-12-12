package br.com.ktrak.domain.dto;

import lombok.Getter;

@Getter
public class DiaLetivoDto {

    public Long id;
    public String data;
    public TurmaDto turma;

    public DiaLetivoDto(Long id, String data, TurmaDto turma) {
        this.id = id;
        this.data = data;
        this.turma = turma;
    }
}
