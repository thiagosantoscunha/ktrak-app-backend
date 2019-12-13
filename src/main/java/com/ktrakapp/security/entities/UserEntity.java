package com.ktrakapp.security.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ktrakapp.security.enums.Role;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "users")
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 16, unique = true)
    private String username;

    @Column(length = 255)
    private String password;

    @Column
    private LocalDateTime criadoEm;

    @Column
    private LocalDateTime atualizadoEm;

    @Column
    @Enumerated(EnumType.STRING)
    private Role role;
}
