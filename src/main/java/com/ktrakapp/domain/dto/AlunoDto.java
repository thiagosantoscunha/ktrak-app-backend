package com.ktrakapp.domain.dto;

import com.ktrakapp.security.dto.UserDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlunoDto {

    private Long id;
    private String nome;
    private String dataNascimento;
    private String cep;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String estado;
    private Boolean status;

    @Getter
    @Setter
    private UserDto user;

    public AlunoDto() {
    }

    public AlunoDto(String nome, String dataNascimento, String cep, String logradouro, String bairro, String cidade, String estado, Boolean status) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.status = status;
    }

    public AlunoDto(Long id, String nome, String dataNascimento, String cep, String logradouro, String bairro, String cidade, String estado, Boolean status) {
        super();
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.status = status;
    }



}
