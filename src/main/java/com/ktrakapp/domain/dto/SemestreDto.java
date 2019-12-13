package com.ktrakapp.domain.dto;


public class SemestreDto {
    public Long id;
    public String dataInicio;
    public String dataFim;

    public SemestreDto(Long id, String dataInicio, String dataFim) {
        this.id = id;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }
}
