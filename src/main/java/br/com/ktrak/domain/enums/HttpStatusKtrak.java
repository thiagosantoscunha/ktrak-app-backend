package br.com.ktrak.domain.enums;

public enum HttpStatusKtrak {

    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
    QR_CODE_GENERATE_ERROR(201901, "QRCode Generate Error");

    private final int value;
    private final String reasonPhrase;

    HttpStatusKtrak(int value, String reasonPhrase) {
        this.value = value;
        this.reasonPhrase = reasonPhrase;
    }
}
