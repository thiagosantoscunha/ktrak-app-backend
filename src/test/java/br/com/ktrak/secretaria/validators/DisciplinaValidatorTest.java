package br.com.ktrak.secretaria.validators;

import br.com.ktrak.domain.dto.InsereDisciplinaDto;
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

    private InsereDisciplinaDto insereDisciplinaDto;

    @BeforeEach
    void setUp() {
        insereDisciplinaDto = new InsereDisciplinaDto();
        insereDisciplinaDto.nome = "Matemática Discreta";
    }

    @Test
    void podeInserirComSucessoTest() {
        var result = validator.isNaoPodeInserir(insereDisciplinaDto);
        assertFalse(result);
    }

    @Test
    void isNaoPodeInserirSeNomeForNuloTest() {
        insereDisciplinaDto.nome = null;
        var message = assertThrows(BadRequestException.class, () -> validator.isNaoPodeInserir(insereDisciplinaDto)).getMessage();
        assertEquals("A discplina precisa ter um nome", message);
    }

    @Test
    void isNaoPodeInserirSeNomeForVazioTest() {
        insereDisciplinaDto.nome = "";
        var message = assertThrows(BadRequestException.class, () -> validator.isNaoPodeInserir(insereDisciplinaDto)).getMessage();
        assertEquals("A discplina precisa ter um nome", message);
    }

    @Test
    void isNaoPodeInserirSeNomeForMenorQue3CaracteresTest() {
        insereDisciplinaDto.nome = "as";
        var message = assertThrows(BadRequestException.class, () -> validator.isNaoPodeInserir(insereDisciplinaDto)).getMessage();
        assertEquals("O nome da disciplina precisa ter entre 3 a 64 caracteres", message);
    }

    @Test
    void isNaoPodeInserirSeNomeForMaiorQue64CaracteresTest() {
        insereDisciplinaDto.nome = "Geometria análiticamente plana e espacialGeometria análitica Plana";
        var message = assertThrows(BadRequestException.class, () -> validator.isNaoPodeInserir(insereDisciplinaDto)).getMessage();
        assertEquals("O nome da disciplina precisa ter entre 3 a 64 caracteres", message);
    }

    @Test
    void isNaoPodeInserirSeNomeTemCadastradoTest() {
    }

}