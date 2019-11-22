package br.com.ktrak.domain.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MatriculaGeneratorServiceTest {


    @BeforeEach
    void setUp() {
    }

    @Test
    void buildCom13Caracteres() {
        String numero = MatriculaGeneratorService.build();
        System.out.println(numero);
        assertEquals(13, numero.length());
    }
}