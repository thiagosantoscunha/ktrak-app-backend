package br.com.ktrak.domain.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;


@ToString @EqualsAndHashCode
@Entity
@Table(name = "dia_hora_aulas")
public class DiaHoraAulaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @Getter @Setter
    @Column(nullable = false, length = 13)
    private String dia;

    @Getter @Setter
    @Column(length = 10)
    private String hora;

}
