package br.com.ktrak.domain.dto;

public class AlunoDto {

    public Long id;
    public String nome;
    public String dataNascimento;
    public String cep;
    public String logradouro;
    public String bairro;
    public String cidade;
    public String estado;

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
