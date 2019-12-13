package com.ktrakapp.domain.dto.out;


import com.ktrakapp.domain.entities.AlunoEntity;

import java.time.LocalDate;

public class ExibeAlunoDto {

    public Long id;
    public String nome;
    public LocalDate dataNascimento;
    public String cep;
    public String logradouro;
    public String bairro;
    public String cidade;
    public String estado;

    public void toDto(AlunoEntity entity) {
        id = entity.getId();
        nome = entity.getNome();
        dataNascimento = entity.getDataNascimento();
        bairro = entity.getBairro();
        cidade = entity.getCidade();
        estado = entity.getEstado();
        cep = entity.getCep();
        logradouro = entity.getLogradouro();
    }
}
