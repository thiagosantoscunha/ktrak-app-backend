package br.com.ktrak.domain.annotations;

import br.com.ktrak.domain.enums.HttpStatusKtrak;
import org.springframework.core.annotation.AliasFor;
import org.springframework.http.HttpStatus;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ResponseStatusKtrak {

    @AliasFor("code")
    HttpStatusKtrak value() default HttpStatusKtrak.INTERNAL_SERVER_ERROR;

    @AliasFor("value")
    HttpStatusKtrak code() default HttpStatusKtrak.INTERNAL_SERVER_ERROR;

    String reason() default "";

}

