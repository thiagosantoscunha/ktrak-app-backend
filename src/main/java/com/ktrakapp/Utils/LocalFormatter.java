package com.ktrakapp.Utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public abstract class LocalFormatter {
    public static LocalDate toLocalDate(String date) {
        final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(date, dateTimeFormatter);
    }
    public static LocalDateTime toLocalDateTime(String datetime) {
        final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:s");
        return LocalDateTime.parse(datetime, dateTimeFormatter);
    }
    public static LocalTime toLocalTime(String time) {
        final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:s");
        return LocalTime.parse(time, dateTimeFormatter);
    }

    public static LocalDateTime appendDateAndTime(LocalDate date, LocalTime time) {
        return LocalDateTime.of(date, time);
    }
}
