package br.com.ktrak.secretaria.dto;

import br.com.ktrak.domain.entities.PessoaEntity;

public class ListaPessoaDTO {
    public Long id;
    public String nome;
    public String dataNascimento;
    public String bairro;
    public String cidade;
    public String estado;

    public static ListaPessoaDTO toDto(PessoaEntity pessoaEntity) {
        ListaPessoaDTO dto = new ListaPessoaDTO();
        dto.id = pessoaEntity.getId();
        dto.nome = pessoaEntity.getNome();
        dto.estado = pessoaEntity.getEstado();
        dto.bairro = pessoaEntity.getBairro();
        dto.cidade = pessoaEntity.getCidade();
        dto.dataNascimento = pessoaEntity.getDataNascimento().toString();
        return dto;
    }


}
