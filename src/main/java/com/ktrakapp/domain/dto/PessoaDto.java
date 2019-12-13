package com.ktrakapp.domain.dto;

import com.ktrakapp.security.dto.UserDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaDto {
    private Long id;
    private String nome;
    private String dataNascimento;
    private String cep;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String estado;
    private UserDto userDto;

    public PessoaDto() {
    }

    public PessoaDto(Long id, String nome, String dataNascimento, String cep, String logradouro, String bairro, String cidade, String estado) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public PessoaDto(Long id, String nome, String dataNascimento, String cep, String logradouro, String bairro, String cidade, String estado, UserDto userDto) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.userDto = userDto;
    }
}
