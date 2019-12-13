package com.ktrakapp.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PresenciamentoDto {
    private Long id;
    private MatriculaDto matricula;
    private DiaLetivoDto diaLetivo;
    private Boolean isPresente;
}
