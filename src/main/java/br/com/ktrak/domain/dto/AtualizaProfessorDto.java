package br.com.ktrak.domain.dto;

import br.com.ktrak.Utils.LocalDateTimeFormatter;
import br.com.ktrak.domain.entities.ProfessorEntity;

public class AtualizaProfessorDto {
    public Long id;
    public String nome;
    public String dataNascimento;
    public String cep;
    public String logradouro;
    public String bairro;
    public String cidade;
    public String estado;

    public ProfessorEntity toEntity() {
        ProfessorEntity entity = new ProfessorEntity();
        entity.setId(id);
        entity.setNome(nome);
        entity.setDataNascimento(LocalDateTimeFormatter.toLocalDate(dataNascimento));
        entity.setCep(cep);
        entity.setLogradouro(logradouro);
        entity.setBairro(bairro);
        entity.setCidade(cidade);
        entity.setEstado(estado);
        return entity;
    }
}
