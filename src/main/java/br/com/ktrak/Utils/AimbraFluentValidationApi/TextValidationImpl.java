package br.com.ktrak.Utils.AimbraFluentValidationApi;

import br.com.ktrak.Utils.AimbraFluentValidationApi.interfaces.ITextValidation;
import br.com.ktrak.domain.exceptions.BadRequestException;
import org.springframework.stereotype.Component;

@Component
public class TextValidationImpl implements ITextValidation {
    @Override
    public boolean isNull(String value) {
        return value == null;
    }

    @Override
    public boolean isNull(String value, String messageError) {
        if (isNull(value)) throw new BadRequestException(messageError);
        return true;
    }

    @Override
    public boolean isNotNull(String value) {
        return !isNull(value);
    }

    @Override
    public boolean isNotNull(String value, String messageError) {
        if (isNotNull(value)) throw new BadRequestException(messageError);
        return true;
    }

    @Override
    public boolean isNotEmpty(String value) {
        return !value.isEmpty();
    }

    @Override
    public boolean isNotEmpty(String value, String messageError) {
        if (isNotEmpty(value)) throw new BadRequestException(messageError);
        return true;
    }

    @Override
    public boolean isNotNullAndEmpty(String value) {
        return isNotNull(value) && isNotEmpty(value);
    }

    @Override
    public boolean isNotNullAndEmpty(String value, String messageError) {
        if (isNotNull(value) && isNotEmpty(value)) throw new BadRequestException(messageError);
        return true;
    }

    @Override
    public boolean isNullOrEmpty(String value) {
        return isNull(value) || value.isEmpty();
    }

    @Override
    public boolean isNullOrEmpty(String value, String messageError) {
        if ((isNull(value) || value.isEmpty())) throw new BadRequestException(messageError);
        return true;
    }

    @Override
    public boolean invalidLength(String text, Integer minLength, Integer maxLength) {
        return text.length() < minLength && text.length() > maxLength;
    }

    @Override
    public boolean invalidLength(String text, Integer minLength, Integer maxLength, String messageError) {
        if (text.length() < minLength && text.length() > maxLength) throw new BadRequestException(messageError);
        return false;
    }

    @Override
    public boolean invalidLength(String text, String operator, Integer length) {

        switch (operator) {
            case "==":
                if (text.length() == length) return true;
            case "!=":
                if (text.length() != length) return true;
            case ">":
                if (text.length() > length) return true;
            case ">=":
                if (text.length() >= length) return true;
            case "<":
                if (text.length() < length) return true;
            case "<=":
                if (text.length() <= length) return true;
        }

        return false;

    }

    @Override
    public boolean invalidLength(String text, String operator, Integer length, String messageError) {
        switch (operator) {
            case "==":
                if (text.length() == length) sendExption(messageError);
                return true;
            case "!=":
                if (text.length() != length) sendExption(messageError);
                return true;
            case ">":
                if (text.length() > length) sendExption(messageError);
                return true;
            case ">=":
                if (text.length() >= length) sendExption(messageError);
                return true;
            case "<":
                if (text.length() < length) sendExption(messageError);
                return true;
            case "<=":
                if (text.length() <= length) sendExption(messageError);
                return true;
        }

        return false;
    }

    private void sendExption(String messageError) {
        if (isNullOrEmpty(messageError)) {
            throw new BadRequestException(messageError);
        }
    }

}
