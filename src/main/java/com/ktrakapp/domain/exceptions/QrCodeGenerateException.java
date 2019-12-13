package com.ktrakapp.domain.exceptions;


import com.ktrakapp.domain.annotations.ResponseStatusKtrak;
import com.ktrakapp.domain.enums.HttpStatusKtrak;

@ResponseStatusKtrak(HttpStatusKtrak.INTERNAL_SERVER_ERROR)
public class QrCodeGenerateException extends RuntimeException {
    public QrCodeGenerateException(String message) {
        super(message);
    }
}
