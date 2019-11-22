package br.com.ktrak.Utils.AimbraFluentValidationApi;

import br.com.ktrak.domain.exceptions.BadRequestException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NumberValidationImplTest {

    @Autowired
    private NumberValidationImpl numberValidation;

    private Integer number;

    @BeforeEach
    void setUp() {
        number = 20;
    }

    @Test
    void testIsNull() {
        number = null;
        assertEquals(true, numberValidation.isNull(number));
    }


    @Test
    void testIsNullWithThrow() {
        number = null;
        var message = assertThrows(BadRequestException.class, () ->
                numberValidation.isNull(number, "The number is null")
        ).getMessage();
        assertEquals("The number is null", message);
    }

    @Test
    void testIsNotNull() {
        assertEquals(true, numberValidation.isNotNull(number));
    }


    @Test
    void testIsNotNullWithThrow() {
        var message = assertThrows(BadRequestException.class, () -> numberValidation.isNotNull(number, "The number is null"))
                .getMessage();
        assertEquals("The number is null", message);
    }

}