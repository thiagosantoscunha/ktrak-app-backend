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
        if (value == null) {
            if (messageError != null) {
                throw new BadRequestException(messageError);
            }
        }
    }
}
