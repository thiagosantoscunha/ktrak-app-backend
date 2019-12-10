package br.com.ktrak.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AlunoLogadoDto {
    private AlunoDto aluno;
    private String token;
}
