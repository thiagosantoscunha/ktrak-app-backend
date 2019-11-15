package br.com.ktrak.domain.entities;

import javax.persistence.*;
import java.util.Objects;


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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiaHoraAulaEntity that = (DiaHoraAulaEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(dia, that.dia) &&
                Objects.equals(hora, that.hora);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dia, hora);
    }
}
