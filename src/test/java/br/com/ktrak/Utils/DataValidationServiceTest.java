package br.com.ktrak.Utils;

import br.com.ktrak.domain.exceptions.BadRequestException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DataValidationServiceTest {

    @Autowired
    private DataValidationService dataValidation;

    @BeforeEach
    void setUp() {
    }

    @Test
    void isInvalidFormatTest() {
        var dataNascimento = "19/09/1789";
        var message = assertThrows(BadRequestException.class, () -> {
            dataValidation.isInvalidFormat(dataNascimento, "Formato de data inválido");
        }).getMessage();
        assertEquals(message, "Formato de data inválido");
    }

    @Test
    void isInvalidFormatWithoutMessageTest() {
        var dataNascimento = "19/09/1789";
        var message = assertThrows(BadRequestException.class, () -> {
            dataValidation.isInvalidFormat(dataNascimento);
        }).getMessage();
        assertEquals(message, "A data " + dataNascimento + "tem um formato inválido");
    }

}