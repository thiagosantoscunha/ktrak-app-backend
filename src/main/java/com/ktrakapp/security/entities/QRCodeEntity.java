package com.ktrakapp.security.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
