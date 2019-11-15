package br.com.ktrak.domain.dto.in;

import br.com.ktrak.Utils.LocalFormatter;
import br.com.ktrak.domain.entities.AlunoEntity;

public class AtualizaAlunoDto {

    public Long id;
    public String nome;
    public String dataNascimento;
    public String cep;
    public String logradouro;
    public String bairro;
    public String cidade;
    public String estado;

    public AtualizaAlunoDto() {}

    public AtualizaAlunoDto(Long id, String nome, String dataNascimento, String cep, String logradouro, String bairro, String cidade, String estado) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public AlunoEntity toEntity() {
        AlunoEntity entity = new AlunoEntity();
        entity.setId(id);
        entity.setNome(nome);
        entity.setDataNascimento(LocalFormatter.toLocalDate(dataNascimento));
        entity.setCep(cep);
        entity.setLogradouro(logradouro);
        entity.setBairro(bairro);
        entity.setCidade(cidade);
        entity.setEstado(estado);
        return entity;
    }

}
