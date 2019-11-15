package br.com.ktrak.domain.dto;

public class DiaHoraAulaDto {
    public Long id;
    public String dia;
    public String hora;

    public DiaHoraAulaDto() {
    }

    public DiaHoraAulaDto(Long id, String dia, String hora) {
        this.id = id;
        this.dia = dia;
        this.hora = hora;
    }
}
