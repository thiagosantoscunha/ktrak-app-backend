package br.com.ktrak.secretaria.validators;

import br.com.ktrak.domain.dto.AlunoDto;
import br.com.ktrak.domain.dto.in.AtualizaAlunoDto;
import br.com.ktrak.domain.dto.in.InsereAlunoDto;
import br.com.ktrak.domain.exceptions.BadRequestException;
import br.com.ktrak.domain.exceptions.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AlunoValidatorTest {

    @Autowired
    private AlunoValidator validator;

    private AlunoDto aluno;

    @BeforeEach
    void setUp() {
        aluno = new AlunoDto(
                "Thiago dos Santos Celestino da Cunha",
                "18-07-1989",
                "26020087",
                "Rua Santos Moreira, 188",
                "Aquantico",
                "Macaé",
                "Rio de Janeiro"
        );

    }

    @Test
    void insereAlunoComSucesso() {
        var result = validator.isNaoPodeInserir(aluno);
        Assertions.assertFalse(result);
    }

    @Test
    void isNaoPodeInserirSeNomeForNulo() {
        aluno.setNome(null);
        var message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeInserir(aluno);
        }).getMessage();
        assertEquals("O nome esta nulo ou vazio", message);
    }

    @Test
    void isNaoPodeInserirSeNomeForVazio() {
        aluno.setNome("");
        var message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeInserir(aluno);
        }).getMessage();
        assertEquals("O nome esta nulo ou vazio", message);
    }

    @Test
    void isNaoPodeInserirSeNomeForMenorQue10Caracteres() {
        aluno.setNome("Thiago");
        var message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeInserir(aluno);
        }).getMessage();
        assertEquals("O nome precisa ter entre 10 a 64 caracteres", message);
    }

    @Test
    void isNaoPodeInserirSeNomeForMaiorQue64Caracteres() {
        aluno.setNome("Thiago dos Santos Celestino da Cunha Thiago dos Santos Celestino");
        var message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeInserir(aluno);
        }).getMessage();
        assertEquals("O nome precisa ter entre 10 a 64 caracteres", message);
    }

    @Test
    void isNaoPodeInserirSeDataDeNascimentoForNulo() {
        aluno.setDataNascimento(null);
        var message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeInserir(aluno);
        }).getMessage();
        assertEquals("A data de nascimento esta nula ou vázia", message);
    }

    @Test
    void isNaoPodeInserirSeDataDeNascimentoForVazio() {
        aluno.setDataNascimento("");
        Assertions.assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeInserir(aluno);
        });
    }

    @Test
    void isNaoPodeInserirSeDataNascimentoTiverFormatoInvalido() {
        aluno.setDataNascimento("19/09/1789");
        Assertions.assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeInserir(aluno);
        });
    }

    @Test
    void isNaoPodeInserirLogradouroForNulo() {
        aluno.setLogradouro(null);
        var message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeInserir(aluno);
        }).getMessage();
        assertEquals(message, "O logradouro esta nulo ou vazio");
    }

    @Test
    void isNaoPodeInserirLogradouroForVazio() {
        aluno.setLogradouro("");
        var message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeInserir(aluno);
        }).getMessage();
        assertEquals(message, "O logradouro esta nulo ou vazio");
    }

    @Test
    void isNaoPodeInserirLogradouroForMenorQue4Caracteres() {
        aluno.setLogradouro("nul");
        var message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeInserir(aluno);
        }).getMessage();
        assertEquals(message, "O logradouro precisa ter entre 4 a 64 caracteres");
    }

    @Test
    void isNaoPodeInserirLogradouroForMaiorQue64Caracteres() {
        aluno.setLogradouro("Rua das Pacas, condiminio gravata 2 - quadra 20 lote 1100 - Cabo Frio - Rio de Janeiro");
        var message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeInserir(aluno);
        }).getMessage();
        assertEquals(message, "O logradouro precisa ter entre 4 a 64 caracteres");
    }

    @Test
    void isNaoPodeInserirSeCepForNulo() {
        aluno.setCep(null);
        var message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeInserir(aluno);
        }).getMessage();
        assertEquals(message, "O cep está nulo ou vazio");
    }

    @Test
    void isNaoPodeInserirSeCepForDiferenteDe8Caracteres() {
        aluno.setCep("0088");
        var message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeInserir(aluno);
        }).getMessage();
        assertEquals(message, "O tamanho do CEP deve ter 8 caracteres");
    }

    @Test
    void isNaoPodeInserirSeBairroForNulo() {
        aluno.setBairro(null);
        var message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeInserir(aluno);
        }).getMessage();
        assertEquals(message, "O bairro esta nulo ou vazio");
    }

    @Test
    void isNaoPodeInserirSeBairroForVazio() {
        aluno.setBairro("");
        var message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeInserir(aluno);
        }).getMessage();
        assertEquals(message, "O bairro esta nulo ou vazio");
    }

    @Test
    void isNaoPodeInserirSeBairroForMenorQue3Caracteres() {
        aluno.setBairro("nu");
        var message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeInserir(aluno);
        }).getMessage();
        assertEquals(message, "O bairro precisa ter entre 4 a 64 caracteres");
    }

    @Test
    void isNaoPodeInserirSeBairroForMaiorQue64Caracteres() {
        aluno.setBairro("PindamonhagabivectstarpudvksPindamonhagabivectstarpudvksPindamonhagabivectstar");
        var message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeInserir(aluno);
        }).getMessage();
        assertEquals(message, "O bairro precisa ter entre 4 a 64 caracteres");
    }

    @Test
    void isNaoPodeInserirCidadeForNulo() {
        aluno.setCidade(null);
        var message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeInserir(aluno);
        }).getMessage();
        assertEquals(message, "A cidade esta nulo ou vazio");
    }

    @Test
    void isNaoPodeInserirCidadeForVazio() {
        aluno.setCidade("");
        var message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeInserir(aluno);
        }).getMessage();
        assertEquals(message, "A cidade esta nulo ou vazio");
    }

    @Test
    void isNaoPodeInserirCidadeForMenorQue3Caracteres() {
        aluno.setCidade("qw");
        var message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeInserir(aluno);
        }).getMessage();
        assertEquals(message, "A cidade precisa ter entre 4 a 64 caracteres");
    }

    @Test
    void isNaoPodeInserirCidadeForMaiorQue64Caracteres() {
        aluno.setCidade("PindamonhagabivectstarpudvksPindamonhagabivectstarpudvksPindamonhagabivectstar");
        var message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeInserir(aluno);
        }).getMessage();
        assertEquals(message, "A cidade precisa ter entre 4 a 64 caracteres");
    }

    @Test
    void isNaoPodeInserirEstadoForNulo() {
        aluno.setEstado(null);
        var message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeInserir(aluno);
        }).getMessage();
        assertEquals(message, "O estado esta nulo ou vazio");
    }

    @Test
    void isNaoPodeInserirEstadoForVazio() {
        aluno.setEstado("");
        var message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeInserir(aluno);
        }).getMessage();
        assertEquals(message, "O estado esta nulo ou vazio");
    }

    @Test
    void isNaoPodeInserirEstadoForMenorQue3Caracteres() {
        aluno.setEstado("nu");
        var message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeInserir(aluno);
        }).getMessage();
        assertEquals(message, "O estado precisa ter entre 3 a 64 caracteres");
    }

    @Test
    void isNaoPodeInserirEstadoForMaiorQue64Caracteres() {
        aluno.setEstado("PindamonhagabivectstarpudvksPindamonhagabivectstarpudvksPindamonhagabivectstar");
        var message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeInserir(aluno);
        }).getMessage();
        assertEquals(message, "O estado precisa ter entre 3 a 64 caracteres");
    }






    //Atualização do usuário


    @Test
    void atualizaUsuarioComSucesso() {
        var result = validator.isNaoPodeAtualizar(aluno);
        Assertions.assertFalse(result);
    }

    @Test
    void isNaoPodeAtualizarSeIdForNulo() {
        aluno.setId(null);
        var message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeAtualizar(aluno);
        }).getMessage();
        assertEquals("O aluno precisa de um Id", message);
    }

    @Test
    void isNaoPodeAtualizarSeNomeForNulo() {
        aluno.setNome(null);
        var message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeAtualizar(aluno);
        }).getMessage();
        assertEquals("O nome esta nulo ou vazio", message);
    }

    @Test
    void isNaoPodeAtualizarSeNomeForVazio() {
        aluno.setNome("");
        var message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeAtualizar(aluno);
        }).getMessage();
        assertEquals("O nome esta nulo ou vazio", message);
    }

    @Test
    void isNaoPodeAtualizarSeNomeForMenorQue10Caracteres() {
        aluno.setNome("Thiago");
        var message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeAtualizar(aluno);
        }).getMessage();
        assertEquals("O nome precisa ter entre 10 a 64 caracteres", message);
    }

    @Test
    void isNaoPodeAtualizarSeNomeForMaiorQue64Caracteres() {
        aluno.setNome("Thiago dos Santos Celestino da Cunha Thiago dos Santos Celestino ");
        var message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeAtualizar(aluno);
        }).getMessage();
        assertEquals("O nome precisa ter entre 10 a 64 caracteres", message);
    }

    @Test
    void isNaoPodeAtualizarSeDataDeNascimentoForNulo() {
        aluno.setDataNascimento(null);
        var message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeAtualizar(aluno);
        }).getMessage();
        assertEquals("A data de nascimento esta nula ou vázia", message);
    }

    @Test
    void isNaoPodeAtualizarSeDataDeNascimentoForVazio() {
        aluno.setDataNascimento("");
        Assertions.assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeAtualizar(aluno);
        });
    }

    @Test
    void isNaoPodeAtualizarSeDataNascimentoTiverFormatoInvalido() {
        aluno.setDataNascimento("19/09/1789");
        Assertions.assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeAtualizar(aluno);
        });
    }

    @Test
    void isNaoPodeAtualizarLogradouroForNulo() {
        aluno.setLogradouro(null);
        var message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeAtualizar(aluno);
        }).getMessage();
        assertEquals(message, "O logradouro esta nulo ou vazio");
    }

    @Test
    void isNaoPodeAtualizarLogradouroForVazio() {
        aluno.setLogradouro("");
        var message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeAtualizar(aluno);
        }).getMessage();
        assertEquals(message, "O logradouro esta nulo ou vazio");
    }

    @Test
    void isNaoPodeAtualizarLogradouroForMenorQue4Caracteres() {
        aluno.setLogradouro("nul");
        var message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeAtualizar(aluno);
        }).getMessage();
        assertEquals(message, "O logradouro precisa ter entre 4 a 64 caracteres");
    }

    @Test
    void isNaoPodeAtualizarLogradouroForMaiorQue64Caracteres() {
        aluno.setLogradouro("Rua das Pacas, condiminio gravata 2 - quadra 20 lote 1100 - Cabo Frio - Rio de Janeiro");
        var message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeAtualizar(aluno);
        }).getMessage();
        assertEquals(message, "O logradouro precisa ter entre 4 a 64 caracteres");
    }

    @Test
    void isNaoPodeAtualizarSeCepForNulo() {
        aluno.setCep(null);
        var message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeAtualizar(aluno);
        }).getMessage();
        assertEquals(message, "O cep está nulo ou vazio");
    }

    @Test
    void isNaoPodeAtualizarSeCepForDiferenteDe8Caracteres() {
        aluno.setCep("0088");
        var message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeAtualizar(aluno);
        }).getMessage();
        assertEquals(message, "O tamanho do CEP deve ter 8 caracteres");
    }

    @Test
    void isNaoPodeAtualizarSeBairroForNulo() {
        aluno.setBairro(null);
        var message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeAtualizar(aluno);
        }).getMessage();
        assertEquals(message, "O bairro esta nulo ou vazio");
    }

    @Test
    void isNaoPodeAtualizarSeBairroForVazio() {
        aluno.setBairro("");
        var message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeAtualizar(aluno);
        }).getMessage();
        assertEquals(message, "O bairro esta nulo ou vazio");
    }

    @Test
    void isNaoPodeAtualizarSeBairroForMenorQue3Caracteres() {
        aluno.setBairro("nu");
        var message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeAtualizar(aluno);
        }).getMessage();
        assertEquals(message, "O bairro precisa ter entre 4 a 64 caracteres");
    }

    @Test
    void isNaoPodeAtualizarSeBairroForMaiorQue64Caracteres() {
        aluno.setBairro("PindamonhagabivectstarpudvksPindamonhagabivectstarpudvksPindamonhagabivectstar");
        var message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeAtualizar(aluno);
        }).getMessage();
        assertEquals(message, "O bairro precisa ter entre 4 a 64 caracteres");
    }

    @Test
    void isNaoPodeAtualizarCidadeForNulo() {
        aluno.setCidade(null);
        var message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeAtualizar(aluno);
        }).getMessage();
        assertEquals(message, "A cidade esta nulo ou vazio");
    }

    @Test
    void isNaoPodeAtualizarCidadeForVazio() {
        aluno.setCidade("");
        var message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeAtualizar(aluno);
        }).getMessage();
        assertEquals(message, "A cidade esta nulo ou vazio");
    }

    @Test
    void isNaoPodeAtualizarCidadeForMenorQue3Caracteres() {
        aluno.setCidade("qw");
        var message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeAtualizar(aluno);
        }).getMessage();
        assertEquals(message, "A cidade precisa ter entre 4 a 64 caracteres");
    }

    @Test
    void isNaoPodeAtualizarCidadeForMaiorQue64Caracteres() {
        aluno.setCidade("PindamonhagabivectstarpudvksPindamonhagabivectstarpudvksPindamonhagabivectstar");
        var message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeAtualizar(aluno);
        }).getMessage();
        assertEquals(message, "A cidade precisa ter entre 4 a 64 caracteres");
    }

    @Test
    void isNaoPodeAtualizarEstadoForNulo() {
        aluno.setEstado(null);
        var message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeAtualizar(aluno);
        }).getMessage();
        assertEquals(message, "O estado esta nulo ou vazio");
    }

    @Test
    void isNaoPodeAtualizarEstadoForVazio() {
        aluno.setEstado("");
        var message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeAtualizar(aluno);
        }).getMessage();
        assertEquals(message, "O estado esta nulo ou vazio");
    }

    @Test
    void isNaoPodeAtualizarEstadoForMenorQue3Caracteres() {
        aluno.setEstado("nu");
        var message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeAtualizar(aluno);
        }).getMessage();
        assertEquals(message, "O estado precisa ter entre 3 a 64 caracteres");
    }

    @Test
    void isNaoPodeAtualizarEstadoForMaiorQue64Caracteres() {
        aluno.setEstado("PindamonhagabivectstarpudvksPindamonhagabivectstarpudvksPindamonhagabivectstar");
        var message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeAtualizar(aluno);
        }).getMessage();
        assertEquals(message, "O estado precisa ter entre 3 a 64 caracteres");
    }

    @Test
    void isNaoPodeAtualizarSePessoaNaoExiste() {
        aluno.setId(171771717171L);
        var message = assertThrows(NotFoundException.class, () -> {
            validator.isNaoPodeAtualizar(aluno);
        }).getMessage();
        assertEquals(message, "O usuário que você esta tentado atualizar não existe");
    }




    // Não Pode buscar

    @Test
    void isNaoPodeBuscarSeNaoTemUsuario() {
        Long id = -1L;
        var message = assertThrows(NotFoundException.class, () -> {
            validator.isNaoPodeBuscarPorId(id);
        }).getMessage();
        assertEquals(message, "Este aluno não esta cadastrado em nossa base de dados");
    }



    // Não Pode buscar

    @Test
    void isNaoPodeRemoverSeNaoTemUsuario() {
        Long id = -1L;
        var message = assertThrows(NotFoundException.class, () -> {
            validator.isNaoPodeBuscarPorId(id);
        }).getMessage();
        assertEquals(message, "Este aluno não esta cadastrado em nossa base de dados");
    }

}