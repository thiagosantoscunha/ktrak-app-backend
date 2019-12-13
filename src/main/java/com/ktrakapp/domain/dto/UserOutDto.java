package com.ktrakapp.domain.dto;

import com.ktrakapp.security.enums.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserOutDto {
    private Long id;
    private String username;
    private Role role;
    private String criadoEm;
    private String atualizadoEm;

    public UserOutDto(Long id, String username, Role role, String criadoEm, String atualizadoEm) {
        this.id = id;
        this.username = username;
        this.role = role;
        this.criadoEm = criadoEm;
        this.atualizadoEm = atualizadoEm;
    }
}
