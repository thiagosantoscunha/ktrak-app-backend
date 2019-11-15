package br.com.ktrak.Utils.AimbraFluentValidationApi;

import br.com.ktrak.Utils.AimbraFluentValidationApi.interfaces.IDataValidation;
import br.com.ktrak.domain.exceptions.BadRequestException;
import org.springframework.stereotype.Component;

import java.text.ParseException;

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

}
