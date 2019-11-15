package br.com.ktrak.Utils.AimbraFluentValidationApi;

import br.com.ktrak.Utils.AimbraFluentValidationApi.interfaces.IDataValidation;
import br.com.ktrak.domain.exceptions.BadRequestException;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.LocalDate;

@Component
public class DataValidationImpl implements IDataValidation {

    @Override
    public void isInvalidDateFormat(String dataString) {
        try {
            patternDateFormat.setLenient(false);
            var data = patternDateFormat.parse(dataString);
        } catch (ParseException e) {
            throw new BadRequestException("A data " + dataString + "tem um formato inválido");
        }
    }

    @Override
    public void isInvalidDateFormat(String dataString, String messageError) {
        try {
            patternDateFormat.setLenient(false);
            var data = patternDateFormat.parse(dataString);
        } catch (ParseException e) {
            throw new BadRequestException(messageError);
        }
    }

    @Override
    public void isInvalidHourFormat(String dataString) {
        try {
            patternHourFormat.setLenient(false);
            var data = patternHourFormat.parse(dataString);
        } catch (ParseException e) {
            throw new BadRequestException("A hora " + dataString + "tem um formato inválido");
        }
    }

    @Override
    public void isInvalidHourFormat(String dataString, String messageError) {
        try {
            patternHourFormat.setLenient(false);
            var data = patternHourFormat.parse(dataString);
        } catch (ParseException e) {
            throw new BadRequestException(messageError);
        }
    }

    @Override
    public boolean isInvalidRange(LocalDate startDate, LocalDate finishDate) {
        return finishDate.isBefore(startDate);
    }

    @Override
    public void isInvalidRange(LocalDate startDate, LocalDate finishDate, String messageError) {
        if (finishDate.isBefore(startDate)) {
            throw new BadRequestException(messageError);
        }
    }

    @Override
    public void isNotDayOfWeek(String day, String messageError) {
        if (isNotDayOfWeek(day)) {
            throw new BadRequestException(messageError);
        }
    }

    @Override
    public boolean isNotDayOfWeekend(LocalDate date) {
        return !(date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY);
    }

    @Override
    public boolean isNotDayOfWeek(String day) {
        return !DayOfWeek.valueOf(day).toString().equals(day);
    }

    @Override
    public void isDayOfWeekend(LocalDate date, String messageError) {
        if (isDayOfWeekend(date)) {
            throw new BadRequestException(messageError);
        }
    }

    @Override
    public boolean isDayOfWeekend(String dia) {
        return (DayOfWeek.SATURDAY.toString().equals(dia) || DayOfWeek.SUNDAY.toString().equals(dia));
    }

    @Override
    public void isDayOfWeekend(String dia, String messageError) {
        if (isDayOfWeekend(dia)) {
            throw new BadRequestException(messageError);
        }
    }

    @Override
    public boolean isDayOfWeekend(LocalDate date) {
        return date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY;
    }

}
