package br.com.ktrak.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class AlunoDto {

    private Long id;
    private String nome;
    private String dataNascimento;
    private String cep;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String estado;

    public AlunoDto() {
    }

    public AlunoDto(String nome, String dataNascimento, String cep, String logradouro, String bairro, String cidade, String estado) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public AlunoDto(Long id, String nome, String dataNascimento, String cep, String logradouro, String bairro, String cidade, String estado) {
        super();
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }


}
