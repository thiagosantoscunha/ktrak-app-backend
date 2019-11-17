package br.com.ktrak.domain.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "dia_hora_aulas")
public class DiaHoraAulaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 13)
    private String dia;

    @Column(length = 10)
    private String hora;

}
