package br.com.ktrak.Utils.AimbraFluentValidationApi;

import br.com.ktrak.Utils.AimbraFluentValidationApi.interfaces.INumberValidation;
import br.com.ktrak.domain.exceptions.BadRequestException;
import org.springframework.stereotype.Component;

@Component
public class NumberValidationImpl implements INumberValidation {
    @Override
    public boolean isNull(Number value) {
        return value == null;
    }

    @Override
    public void isNull(Number value, String messageError) {
        if (isNull(value)) {
            if (messageError != null) {
                throw new BadRequestException(messageError);
            }
        }
    }

    @Override
    public boolean isNotNull(Number value) {
        return !isNull(value);
    }

    @Override
    public void isNotNull(Number value, String messageError) {
        if (isNotNull(value)) {
            if (messageError != null) {
                throw new BadRequestException(messageError);
            }
        }
    }
}
