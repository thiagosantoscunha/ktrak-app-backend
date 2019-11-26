package br.com.ktrak.secretaria.validators;

import br.com.ktrak.domain.dto.DisciplinaDto;
import br.com.ktrak.secretaria.validators.DisciplinaValidator;
import br.com.ktrak.domain.dto.in.InsereDisciplinaDto;
import br.com.ktrak.domain.exceptions.BadRequestException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DisciplinaValidatorTest {

    @Autowired
    private DisciplinaValidator validator;

    private DisciplinaDto insereDisciplinaDto;

    @BeforeEach
    void setUp() {
        insereDisciplinaDto = new DisciplinaDto();
        insereDisciplinaDto.nome = "Matemática Discreta";
    }

    @Test
    void podeInserirComSucessoTest() {
        assertFalse(validator.isNaoPodeInserir(insereDisciplinaDto));
    }

    @Test
    void isNaoPodeInserirSeNomeForNuloTest() {
        insereDisciplinaDto.nome = null;
        String message = assertThrows(BadRequestException.class, () -> validator.isNaoPodeInserir(insereDisciplinaDto)).getMessage();
        assertEquals("A discplina precisa ter um nome", message);
    }

    @Test
    void isNaoPodeInserirSeNomeForVazioTest() {
        insereDisciplinaDto.nome = "";
        String message = assertThrows(BadRequestException.class, () -> validator.isNaoPodeInserir(insereDisciplinaDto)).getMessage();
        assertEquals("A discplina precisa ter um nome", message);
    }

    @Test
    void isNaoPodeInserirSeNomeForMenorQue3CaracteresTest() {
        insereDisciplinaDto.nome = "as";
        String message = assertThrows(BadRequestException.class, () -> validator.isNaoPodeInserir(insereDisciplinaDto)).getMessage();
        assertEquals("O nome da disciplina precisa ter entre 3 a 64 caracteres", message);
    }

    @Test
    void isNaoPodeInserirSeNomeForMaiorQue64CaracteresTest() {
        insereDisciplinaDto.nome = "Geometria análiticamente plana e espacialGeometria análitica Plana";
        String message = assertThrows(BadRequestException.class, () -> validator.isNaoPodeInserir(insereDisciplinaDto)).getMessage();
        assertEquals("O nome da disciplina precisa ter entre 3 a 64 caracteres", message);
    }

    @Test
    void isNaoPodeInserirSeNomeTemCadastradoTest() {
    }

}