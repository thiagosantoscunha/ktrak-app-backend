package br.com.ktrak.Utils;

import br.com.ktrak.domain.exceptions.BadRequestException;
import org.springframework.stereotype.Component;

@Component
public class TextValidationService {

    public boolean isNull(String text) {
        return text == null;
    }

    public boolean isNotNull(String text) {
        return text != null;
    }

    public boolean isNotEmpty(String text) {
        return !text.isEmpty();
    }

    public boolean isNotNullAndEmpty(String text) {
        return isNotNull(text) && !text.isEmpty();
    }

    public boolean isNullOrEmpty(String text) {
        return isNull(text) || text.isEmpty();
    }

    public void isNullOrEmpty(String text, String messageError) {
        if (isNullOrEmpty(text)) {
            throw new BadRequestException(messageError);
        }
    }

    public void invalidLength(String text, String operator, Integer length, String message) {
        switch (operator) {
            case "==":
                if (text.length() == length) {
                    throw new BadRequestException(message);
                }
            case "!=":
                if (text.length() != length) {
                    throw new BadRequestException(message);
                }
        }
    }

    public boolean invalidLength(String text, Integer minLength, Integer maxLength) {
        return text.length() < minLength || text.length() > maxLength;
    }

    public void invalidLength(String text, Integer minLength, Integer maxLength, String messageError) {
        if (invalidLength(text, minLength, maxLength)) {
            if (isNotNullAndEmpty(messageError)) {
                throw new BadRequestException(messageError);
            }
        }
    }

}
