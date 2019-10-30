package br.com.ktrak.secretaria.dto;

import br.com.ktrak.Utils.LocalDateTimeFormatter;
import br.com.ktrak.domain.entities.PessoaEntity;

public class CriaPessoaDTO {
    public String nome;
    public String dataNascimento;
    public String bairro;
    public String cidade;
    public String estado;
    public String digital;

    public PessoaEntity toEntity() {
        PessoaEntity entity = new PessoaEntity();
        entity.setNome(nome);
        entity.setDataNascimento(LocalDateTimeFormatter.formatter(dataNascimento));
        entity.setBairro(bairro);
        entity.setCidade(cidade);
        entity.setEstado(estado);
        entity.setDigital(digital);
        return entity;
    }
}
