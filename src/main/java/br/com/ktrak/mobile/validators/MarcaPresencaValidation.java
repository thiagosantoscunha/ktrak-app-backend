package br.com.ktrak.mobile.validators;

import br.com.ktrak.Utils.AimbraFluentValidationApi.DataValidationImpl;
import br.com.ktrak.Utils.AimbraFluentValidationApi.TextValidationImpl;
import br.com.ktrak.domain.dto.*;
import br.com.ktrak.domain.exceptions.BadRequestException;
import br.com.ktrak.domain.exceptions.NotFoundException;
import br.com.ktrak.domain.services.*;
import br.com.ktrak.security.services.AuthService;
import br.com.ktrak.security.services.QRCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class MarcaPresencaValidation {

    @Autowired
    private TextValidationImpl textValidation;

    @Autowired
    private DataValidationImpl dataValidation;

    @Autowired
    private AuthService authService;

    @Autowired
    private RecessoService recessoService;


    @Autowired
    private QRCodeService qrCodeService;


    public boolean isNaoPodeMarcarPresenca(MarcaPresencaDto dto) {

        textValidation.isNullOrEmpty(dto.getUsername(), "Aluno esta vazio");
        textValidation.isNullOrEmpty(dto.getKey(), "A chave esta vazia");
        dataValidation.isDayOfWeekend(LocalDate.now() ,"Este dia é um final de semana");

        LocalDate dataDeHoje = LocalDate.now();
        String dataDeHojeString = dataDeHoje.getYear() + "-" + dataDeHoje.getMonthValue() + "-" + dataDeHoje.getDayOfMonth();
        if (recessoService.existePorData(dataDeHojeString)) {
            throw new BadRequestException("Este dia é um feriado");
        }

        if (!qrCodeService.existePorKey(dto.getKey())) {
            throw new NotFoundException("Chave não identificada.");
        }

        if (!authService.existePorUsername(dto.getUsername())) {
            throw new NotFoundException("Não existe este usuário cadastrado.");
        }

        return false;
    }



}
