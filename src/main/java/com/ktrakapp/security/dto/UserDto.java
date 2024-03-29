package com.ktrakapp.security.dto;

public class UserDto {
    public Long id;
    public String username;
    public String password;
    public String criadoEm;
    public String atualizadoEm;

    public UserDto(Long id, String username, String password, String criadoEm, String atualizadoEm) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.criadoEm = criadoEm;
        this.atualizadoEm = atualizadoEm;
    }

    public UserDto(Long id, String username) {
        this.id = id;
        this.username = username;
    }
}
