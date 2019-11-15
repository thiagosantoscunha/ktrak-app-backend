package br.com.ktrak.Utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class LocalFormatter {
    public static LocalDate toLocalDate(String date) {
        final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(date, dateTimeFormatter);
    }
    public static LocalDateTime toLocalDateTime(String date) {
        final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:s");
        return LocalDateTime.parse(date, dateTimeFormatter);
    }
}
