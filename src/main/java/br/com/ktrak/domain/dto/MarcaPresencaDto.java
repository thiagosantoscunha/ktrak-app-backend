package br.com.ktrak.domain.dto;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MarcaPresencaDto {

    private String username;
    private String key;

    public MarcaPresencaDto(String username, String key) {
        this.username = username;
        this.key = key;
    }

}
