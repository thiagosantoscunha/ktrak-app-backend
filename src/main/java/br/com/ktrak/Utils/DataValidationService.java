package br.com.ktrak.Utils;

import br.com.ktrak.domain.exceptions.BadRequestException;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Component
public class DataValidationService {

    private SimpleDateFormat patternFormat = new SimpleDateFormat("dd-MM-yyyy");

    public void isInvalidFormat(String dataString) {
        try {
            patternFormat.setLenient(false);
            var data = patternFormat.parse(dataString);
        } catch (ParseException e) {
            throw new BadRequestException("A data " + dataString + "tem um formato inválido");
        }
    }

    public void isInvalidFormat(String dataString, String message) {
        try {
            patternFormat.setLenient(false);
            var data = patternFormat.parse(dataString);
        } catch (ParseException e) {
            throw new BadRequestException(message);
        }
    }

}
