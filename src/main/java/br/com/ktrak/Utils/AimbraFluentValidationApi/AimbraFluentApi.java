package br.com.ktrak.Utils.AimbraFluentValidationApi;

import br.com.ktrak.Utils.AimbraFluentValidationApi.interfaces.IDataValidation;
import br.com.ktrak.Utils.AimbraFluentValidationApi.interfaces.INumberValidation;
import br.com.ktrak.Utils.AimbraFluentValidationApi.interfaces.IObjectValidation;
import br.com.ktrak.Utils.AimbraFluentValidationApi.interfaces.ITextValidation;
import org.springframework.stereotype.Service;

@Service
public abstract class AimbraFluentApi implements ITextValidation, INumberValidation, IDataValidation, IObjectValidation {
}