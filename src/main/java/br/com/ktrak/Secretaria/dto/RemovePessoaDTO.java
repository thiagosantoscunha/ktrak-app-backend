package br.com.ktrak.secretaria.dto;

import br.com.ktrak.Utils.LocalDateTimeFormatter;
import br.com.ktrak.domain.entities.PessoaEntity;

public class RemovePessoaDTO {
    public Long id;
    public String nome;
    public String dataNascimento;
    public String bairro;
    public String cidade;
    public String estado;
    public String digital;

    public PessoaEntity toEntity() {
        if (id != null) {
            PessoaEntity entity = new PessoaEntity();
            entity.setId(id);
            entity.setNome(nome);
            entity.setDataNascimento(LocalDateTimeFormatter.formatter(dataNascimento));
            entity.setBairro(bairro);
            entity.setCidade(cidade);
            entity.setEstado(estado);
            entity.setDigital(digital);
            return entity;
        }
        return null;
    }
}
