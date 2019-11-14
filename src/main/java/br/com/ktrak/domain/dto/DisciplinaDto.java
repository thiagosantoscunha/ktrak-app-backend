package br.com.ktrak.domain.dto;

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
