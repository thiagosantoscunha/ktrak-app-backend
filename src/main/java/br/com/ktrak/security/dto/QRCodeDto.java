package br.com.ktrak.security.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class QRCodeDto {
    private LocalDate criadoEm;
    private String key;
}
