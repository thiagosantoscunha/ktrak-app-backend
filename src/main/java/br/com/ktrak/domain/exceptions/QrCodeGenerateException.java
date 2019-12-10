package br.com.ktrak.domain.exceptions;


import br.com.ktrak.domain.annotations.ResponseStatusKtrak;
import br.com.ktrak.domain.enums.HttpStatusKtrak;

@ResponseStatusKtrak(HttpStatusKtrak.INTERNAL_SERVER_ERROR)
public class QrCodeGenerateException extends RuntimeException {
    public QrCodeGenerateException(String message) {
        super(message);
    }
}
