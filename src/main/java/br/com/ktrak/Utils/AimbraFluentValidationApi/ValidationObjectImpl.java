package br.com.ktrak.Utils.AimbraFluentValidationApi;

import br.com.ktrak.Utils.AimbraFluentValidationApi.interfaces.IValidationObject;
import br.com.ktrak.domain.exceptions.BadRequestException;

public class ValidationObjectImpl implements IValidationObject {

    @Override
    public boolean isNull(Object o) {
        return o == null;
    }

    @Override
    public boolean isNull(Object o, String messageError) {
        if (isNull(o)) throw new BadRequestException(messageError);
        return false;
    }

    @Override
    public boolean isNotNull(Object o) {
        return o != null;
    }

    @Override
    public boolean isNotNull(Object o, String messageError) {
        if (isNotNull(o)) if (isNull(o)) throw new BadRequestException(messageError);
        return false;
    }

}
