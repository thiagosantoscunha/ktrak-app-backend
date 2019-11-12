package br.com.ktrak.Utils.AimbraFluentValidationApi.interfaces;

import java.util.Optional;

public interface INumberValidation {

    boolean isNull(Number value);
    void isNull(Number value, String messageError);

}
