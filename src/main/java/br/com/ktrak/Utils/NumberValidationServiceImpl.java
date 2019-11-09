package br.com.ktrak.Utils;

import br.com.ktrak.domain.exceptions.BadRequestException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class NumberValidationServiceImpl {
    public boolean isNull(Long value) {
        return value == null;
    }

    public boolean isNull(Double value) {
        return value == null;
    }

    public boolean isNull(BigDecimal value) {
        return value == null;
    }

    public boolean isNotNull(Object value) {
        return value != null;
    }

    public boolean isNotNull(Double value) {
        return value != null;
    }

    public boolean isNotNull(BigDecimal value) {
        return value != null;
    }

    public void isNull(Long value, String messageError) {
        if (value == null) {
            throw new BadRequestException(messageError);
        }
    }

    public void isNull(Double value, String messageError) {
        if (value == null) {
            throw new BadRequestException(messageError);
        }
    }

    public void isNull(BigDecimal value, String messageError) {
        if (value == null) {
            throw new BadRequestException(messageError);
        }
    }

    public void isNotNull(Object value, String messageError) {
        if (value != null) {
            throw new BadRequestException(messageError);
        }
    }

    public void isNotNull(Double value, String messageError) {
        if (value != null) {
            throw new BadRequestException(messageError);
        }
    }

    public void isNotNull(BigDecimal value, String messageError) {
        if (value != null) {
            throw new BadRequestException(messageError);
        }
    }
}
