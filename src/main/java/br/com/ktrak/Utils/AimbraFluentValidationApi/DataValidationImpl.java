package br.com.ktrak.Utils.AimbraFluentValidationApi;

import br.com.ktrak.Utils.AimbraFluentValidationApi.interfaces.IDataValidation;
import br.com.ktrak.domain.exceptions.BadRequestException;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DataValidationImpl implements IDataValidation {

    @Override
    public void isInvalidFormat(String dataString) {
        try {
            patternFormat.setLenient(false);
            var data = patternFormat.parse(dataString);
        } catch (ParseException e) {
            throw new BadRequestException("A data " + dataString + "tem um formato inválido");
        }
    }

    @Override
    public void isInvalidFormat(String dataString, String message) {
        try {
            patternFormat.setLenient(false);
            var data = patternFormat.parse(dataString);
        } catch (ParseException e) {
            throw new BadRequestException(message);
        }
    }

}
