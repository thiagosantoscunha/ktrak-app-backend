package br.com.ktrak.Utils.AimbraFluentValidationApi.interfaces;

import java.text.SimpleDateFormat;

public interface IDataValidation {
    SimpleDateFormat patternFormat = new SimpleDateFormat("dd-MM-yyyy");
    void isInvalidFormat(String dataString);
    void isInvalidFormat(String dataString, String messageError);
}
