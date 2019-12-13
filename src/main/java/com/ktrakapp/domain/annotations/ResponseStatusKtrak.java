package com.ktrakapp.domain.annotations;

import com.ktrakapp.domain.enums.HttpStatusKtrak;
import org.springframework.core.annotation.AliasFor;

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

