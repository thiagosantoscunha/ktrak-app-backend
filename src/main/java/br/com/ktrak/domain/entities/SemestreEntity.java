package br.com.ktrak.domain.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "semestres")
@ToString @EqualsAndHashCode
public class SemestreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @Column
    @Getter @Setter
    private LocalDate dataInicio;

    @Column
    @Getter @Setter
    private LocalDate dataFim;

}
