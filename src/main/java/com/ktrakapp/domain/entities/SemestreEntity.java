package com.ktrakapp.domain.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "semestres")
public class SemestreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDate dataInicio;

    @Column
    private LocalDate dataFim;

}
