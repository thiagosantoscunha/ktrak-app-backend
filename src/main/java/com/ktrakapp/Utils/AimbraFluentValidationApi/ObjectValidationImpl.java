package com.ktrakapp.Utils.AimbraFluentValidationApi;


import com.ktrakapp.Utils.AimbraFluentValidationApi.interfaces.IObjectValidation;
import com.ktrakapp.domain.exceptions.BadRequestException;
import org.springframework.stereotype.Component;

@Component
public class ObjectValidationImpl implements IObjectValidation {

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
        if (isNotNull(o)) {
            throw new BadRequestException(messageError);
        }
        return false;
    }

}
