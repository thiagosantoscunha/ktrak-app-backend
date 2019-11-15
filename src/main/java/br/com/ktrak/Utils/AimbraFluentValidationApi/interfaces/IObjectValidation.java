package br.com.ktrak.Utils.AimbraFluentValidationApi.interfaces;

import org.springframework.stereotype.Component;

public interface IObjectValidation {
    boolean isNull(Object o);
    boolean isNull(Object o, String messageError);
    boolean isNotNull(Object o);
    boolean isNotNull(Object o, String messageError);
}
