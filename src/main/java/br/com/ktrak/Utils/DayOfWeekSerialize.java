package br.com.ktrak.Utils;


import br.com.ktrak.domain.exceptions.BadRequestException;

import java.time.LocalDate;

public abstract class DayOfWeekSerialize {

    public static String getDayOfWeekToStringEnglishToPortuguese(LocalDate date) {
        switch (date.getDayOfWeek()) {
            case MONDAY:
                return "SEGUNDA-FEIRA";
            case TUESDAY:
                return "TERÇA-FEIRA";
            case THURSDAY:
                return "QUARTA-FEIRA";
            case WEDNESDAY:
                return "QUINTA-FEIRA";
            case FRIDAY:
                return "SEXTA-FEIRA";
            case SATURDAY:
                return "SÁBADO";
            case SUNDAY:
                return "DOMINGO";
            default:
                throw new BadRequestException("Não foi possível localizar a data");
        }
    }
}
