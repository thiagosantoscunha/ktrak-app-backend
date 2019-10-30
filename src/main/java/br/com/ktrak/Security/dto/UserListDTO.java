package br.com.ktrak.security.dto;

import java.time.LocalDateTime;

public class UserListDTO {
    public Long id;
    public String username;
    public LocalDateTime criadoEm;
    public LocalDateTime atualizadoEm;

    public UserListDTO(Long id, String username, LocalDateTime criadoEm, LocalDateTime atualizadoEm) {
        this.id = id;
        this.username = username;
        this.criadoEm = criadoEm;
        this.atualizadoEm = atualizadoEm;
    }
}
