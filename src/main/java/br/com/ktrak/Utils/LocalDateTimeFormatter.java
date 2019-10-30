package br.com.ktrak.Utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class LocalDateTimeFormatter {
    public static LocalDateTime formatter(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return LocalDateTime.parse(date, formatter);

    }
}
