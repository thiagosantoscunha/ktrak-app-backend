package br.com.ktrak.Utils.AimbraFluentValidationApi;

import br.com.ktrak.domain.exceptions.BadRequestException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ObjectValidationImplTest {

    @Autowired
    private ObjectValidationImpl validation;

    Object o;

    @BeforeEach
    void setUp() {
        o = new Object();
    }

    @Test
    void isNull() {
        o = null;
        assertTrue(validation.isNull(o));
    }

    @Test
    void testIsNullWithThrow() {
        o = null;
        assertThrows(BadRequestException.class, () -> {
            validation.isNull(o, "The Object is null");
        });
    }

    @Test
    void isNotNull() {
        assertTrue(validation.isNotNull(o));
    }

    @Test
    void testIsNotNull() {
        assertThrows(BadRequestException.class, () -> {
            validation.isNotNull(o, "The Object is null");
        });
    }
}