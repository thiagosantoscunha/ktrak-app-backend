package br.com.ktrak.Utils.AimbraFluentValidationApi.interfaces;

import org.springframework.stereotype.Component;

public interface ITextValidation {
    boolean isNull(String value);
    boolean isNull(String value, String messageError);
    boolean isNotNull(String value);
    boolean isNotNull(String value, String messageError);
    boolean isNotEmpty(String value);
    boolean isNotEmpty(String value, String messageError);
    boolean isNotNullAndEmpty(String value);
    boolean isNotNullAndEmpty(String value, String messageError);
    boolean isNullOrEmpty(String value);
    boolean isNullOrEmpty(String value, String messageError);
    boolean invalidLength(String text, Integer minLength, Integer maxLength);
    boolean invalidLength(String text, Integer minLength, Integer maxLength, String messageError);
    boolean invalidLength(String text, String operator, Integer length);
    boolean invalidLength(String text, String operator, Integer length, String messageError);
}
