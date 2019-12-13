package br.com.ktrak.Utils.AimbraFluentValidationApi.interfaces;

import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

public interface IDataValidation {
    SimpleDateFormat patternDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat patternHourFormat = new SimpleDateFormat("HH:mm:s");
    void isInvalidDateFormat(String dataString);
    void isInvalidDateFormat(String dataString, String messageError);
    void isInvalidHourFormat(String dataString);
    void isInvalidHourFormat(String dataString, String messageError);
    boolean isInvalidRange(LocalDate startDate, LocalDate finishDate);
    void isInvalidRange(LocalDate startDate, LocalDate finishDate, String messageError);
    boolean isDayOfWeekend(LocalDate date);
    void isDayOfWeekend(LocalDate date, String message);
    boolean isDayOfWeekend(String dia);
    void isDayOfWeekend(String dia, String messageError);
    boolean isNotDayOfWeek(String day);
    void isNotDayOfWeek(String day, String messageError);
    boolean isNotDayOfWeekend(LocalDate date);
    boolean isNowBetweenDateTime(final DateTime startDate, final DateTime endDate);
}
