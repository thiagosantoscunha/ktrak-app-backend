package br.com.ktrak.security.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "qr_codes")
public class QRCodeEntity {

    @Column(unique = true)
    private String key;

    @Id
    @Column(unique = true)
    private LocalDate criadoEm;

}
