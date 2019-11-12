package br.com.ktrak.Utils.AimbraFluentValidationApi.interfaces;

public interface IValidationObject {
    boolean isNull(Object o);
    boolean isNull(Object o, String messageError);
    boolean isNotNull(Object o);
    boolean isNotNull(Object o, String messageError);
}
