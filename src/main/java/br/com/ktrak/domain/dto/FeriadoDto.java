package br.com.ktrak.domain.dto;

public class FeriadoDto {

    public Long id;
    public String data;

    public FeriadoDto() {
    }

    public FeriadoDto(Long id, String data) {
        this.id = id;
        this.data = data;
    }
}
