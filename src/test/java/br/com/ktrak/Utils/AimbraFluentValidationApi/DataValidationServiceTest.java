package br.com.ktrak.Utils.AimbraFluentValidationApi;

import br.com.ktrak.Utils.AimbraFluentValidationApi.DataValidationImpl;
import br.com.ktrak.domain.exceptions.BadRequestException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DataValidationServiceTest {

    @Autowired
    private DataValidationImpl dataValidation;

    @BeforeEach
    void setUp() {
    }

    @Test
    void isValidFormatDateTest() {
        String dataNascimento = "1979-12-15";
        dataValidation.isInvalidDateFormat(dataNascimento);
    }

    @Test
    void isInvalidFormatTest() {
        String dataNascimento = "19/09/1789";
        String message = assertThrows(BadRequestException.class, () -> {
            dataValidation.isInvalidDateFormat(dataNascimento, "Formato de data inválido");
        }).getMessage();
        assertEquals(message, "Formato de data inválido");
    }

    @Test
    void isInvalidFormatWithoutMessageTest() {
        String dataNascimento = "19/09/1789";
        String message = assertThrows(BadRequestException.class, () -> {
            dataValidation.isInvalidDateFormat(dataNascimento);
        }).getMessage();
        assertEquals(message, "A data " + dataNascimento + "tem um formato inválido");
    }

}