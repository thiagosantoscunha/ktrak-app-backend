package br.com.ktrak.Utils.AimbraFluentValidationApi;

import br.com.ktrak.domain.dto.in.InsereAlunoDto;
import br.com.ktrak.domain.exceptions.BadRequestException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TextValidationImplTest {

    @Autowired private TextValidationImpl validation;

    String value;

    @BeforeEach
    void setUp() {
        value = new String("Text Validation Test");
    }

    @Test
    void isNull() {
        value = null;
        boolean result = validation.isNull(value);
        Assertions.assertTrue(result);
    }

    @Test
    void isNullThrownTest() {
        value = null;
        String messageError = "The text value is null";
        String message = Assertions.assertThrows(BadRequestException.class, () -> {
            validation.isNull(value, messageError);
        }).getMessage();
        assertEquals(messageError, message);
    }

    @Test
    void isNotNull() {
        value = "null";
        boolean result = validation.isNotNull(value);
        Assertions.assertTrue(result);
    }

    @Test
    void isNotNullThrownTest() {
        value = "null";
        String messageError = "The text value is not null";
        String message = Assertions.assertThrows(BadRequestException.class, () -> {
            validation.isNotNull(value, messageError);
        }).getMessage();
        assertEquals(messageError, message);
    }

    @Test
    void isNotEmpty() {
        value = "No empty";
        boolean result = validation.isNotEmpty(value);
        Assertions.assertTrue(result);
    }

    @Test
    void IsNotEmptyThrownTest() {
        value = "null";
        String messageError = "The text value is not empty";
        String message = Assertions.assertThrows(BadRequestException.class, () -> {
            validation.isNotEmpty(value, messageError);
        }).getMessage();
        assertEquals(messageError, message);
    }

    @Test
    void isNotNullAndEmpty() {
        value = "No empty";
        boolean result = validation.isNotNullAndEmpty(value);
        Assertions.assertTrue(result);
    }

    @Test
    void isNotNullAndEmptyThrownTest() {
        value = "null";
        String messageError = "The text value was not null and empty";
        String message = Assertions.assertThrows(BadRequestException.class, () -> {
            validation.isNotNullAndEmpty(value, messageError);
        }).getMessage();
        assertEquals(messageError, message);
    }

    @Test
    void isNullOrEmpty() {
        value = "";
        boolean result = validation.isNullOrEmpty(value);
        Assertions.assertTrue(result);
    }


    @Test
    void IsNullOrEmptyThrownTest() {
        value = "null";
        String messageError = "The text value is null or empty";
        String message = Assertions.assertThrows(BadRequestException.class, () -> {
            validation.isNotNullAndEmpty(value, messageError);
        }).getMessage();
        assertEquals(messageError, message);
    }

    @Test
    void invalidLength() {
        value = "Hello";
        boolean result = validation.invalidLength(value, 2, 10);
        Assertions.assertTrue(result);
    }

    @Test
    void testInvalidLength() {
    }

    @Test
    void testInvalidLength1() {
    }

    @Test
    void testInvalidLength2() {
    }
}