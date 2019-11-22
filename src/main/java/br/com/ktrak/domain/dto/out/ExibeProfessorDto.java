package br.com.ktrak.domain.dto.out;

import br.com.ktrak.domain.entities.ProfessorEntity;

import java.time.LocalDate;

public class ExibeProfessorDto {
    public Long id;
    public String nome;
    public LocalDate dataNascimento;
    public String logradouro;
    public String cep;
    public String bairro;
    public String cidade;
    public String estado;

    public void toDto(ProfessorEntity entity) {
        id = entity.getId();
        nome = entity.getNome();
        dataNascimento = entity.getDataNascimento();
        logradouro = entity.getLogradouro();
        cep = entity.getCep();
        bairro = entity.getBairro();
        cidade = entity.getCidade();
        estado = entity.getEstado();
    }
}
