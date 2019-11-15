package br.com.ktrak.Utils.AimbraFluentValidationApi.interfaces;

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
    boolean isDayOfWeek(LocalDate date);
    void isDayOfWeek(LocalDate date, String message);
}
