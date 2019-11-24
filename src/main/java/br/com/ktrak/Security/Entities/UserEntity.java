package br.com.ktrak.security.entities;

import br.com.ktrak.security.enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    @Column(length = 16)
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
