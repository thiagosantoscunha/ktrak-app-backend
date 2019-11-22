package br.com.ktrak.Utils.AimbraFluentValidationApi.interfaces;

import org.springframework.stereotype.Component;

public interface INumberValidation {

    boolean isNull(Number value);
    void isNull(Number value, String messageError);
    boolean isNotNull(Number value);
    void isNotNull(Number value, String messageError);

}
