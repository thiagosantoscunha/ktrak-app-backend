package br.com.ktrak.secretaria.validators;

import br.com.ktrak.domain.dto.AtualizaAlunoDto;
import br.com.ktrak.domain.dto.InsereAlunoDto;
import br.com.ktrak.domain.exceptions.BadRequestException;
import br.com.ktrak.domain.exceptions.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AlunoValidatorTest {

    @Autowired
    private AlunoValidator validator;

    private InsereAlunoDto aluno;
    private AtualizaAlunoDto atualizaAluno;

    @BeforeEach
    void setUp() {
        aluno = new InsereAlunoDto(
                "Thiago dos Santos Celestino da Cunha",
                "18-07-1989",
                "26020087",
                "Rua Santos Moreira, 188",
                "Aquantico",
                "Macaé",
                "Rio de Janeiro"
        );

        atualizaAluno = new AtualizaAlunoDto();
        atualizaAluno.id = 1L;
        atualizaAluno.nome = "Thiago dos Santos Celestino da Cunha";
        atualizaAluno.dataNascimento = "18-07-1989";
        atualizaAluno.cep = "26020087";
        atualizaAluno.logradouro = "Rua Santos Moreira, 188";
        atualizaAluno.bairro = "Aquantico";
        atualizaAluno.cidade = "Macaé";
        atualizaAluno.estado = "Rio de Janeiro";
    }

    @Test
    void insereUsuarioComSucesso() {
        var result = validator.isNaoPodeInserir(aluno);
        Assertions.assertFalse(result);
    }

    @Test
    void isNaoPodeInserirSeNomeForNulo() {
        aluno.nome = null;
        var message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeInserir(aluno);
        }).getMessage();
        assertEquals("O nome esta nulo ou vazio", message);
    }

    @Test
    void isNaoPodeInserirSeNomeForVazio() {
        aluno.nome = "";
        var message = assertThrows(BadRequestException.class, () -> {
            var result = validator.isNaoPodeInserir(aluno);
        }).getMessage();
        assertEquals("O nome esta nulo ou vazio", message);
    }

    @Test
    void isNaoPodeInserirSeNomeForMenorQue10Caracteres() {
        aluno.nome = "Thiago";
        var message = assertThrows(BadRequestException.class, () -> {
            var result = validator.isNaoPodeInserir(aluno);
        }).getMessage();
        assertEquals("O nome precisa ter entre 10 a 64 caracteres", message);
    }

    @Test
    void isNaoPodeInserirSeNomeForMaiorQue64Caracteres() {
        aluno.nome = "Thiago dos Santos Celestino da Cunha Thiago dos Santos Celestino ";
        var message = assertThrows(BadRequestException.class, () -> {
            var result = validator.isNaoPodeInserir(aluno);
        }).getMessage();
        assertEquals("O nome precisa ter entre 10 a 64 caracteres", message);
    }

    @Test
    void isNaoPodeInserirSeDataDeNascimentoForNulo() {
        aluno.dataNascimento = null;
        var message = assertThrows(BadRequestException.class, () -> {
            var result = validator.isNaoPodeInserir(aluno);
        }).getMessage();
        assertEquals("A data de nascimento esta nula ou vázia", message);
    }

    @Test
    void isNaoPodeInserirSeDataDeNascimentoForVazio() {
        aluno.dataNascimento = "";
        Assertions.assertThrows(BadRequestException.class, () -> {
            var result = validator.isNaoPodeInserir(aluno);
        });
    }

    @Test
    void isNaoPodeInserirSeDataNascimentoTiverFormatoInvalido() {
        aluno.dataNascimento = "19/09/1789";
        Assertions.assertThrows(BadRequestException.class, () -> {
            var result = validator.isNaoPodeInserir(aluno);
        });
    }

    @Test
    void isNaoPodeInserirLogradouroForNulo() {
        aluno.logradouro = null;
        var message = assertThrows(BadRequestException.class, () -> {
            var result = validator.isNaoPodeInserir(aluno);
        }).getMessage();
        assertEquals(message, "O logradouro esta nulo ou vazio");
    }

    @Test
    void isNaoPodeInserirLogradouroForVazio() {
        aluno.logradouro = "";
        var message = assertThrows(BadRequestException.class, () -> {
            var result = validator.isNaoPodeInserir(aluno);
        }).getMessage();
        assertEquals(message, "O logradouro esta nulo ou vazio");
    }

    @Test
    void isNaoPodeInserirLogradouroForMenorQue4Caracteres() {
        aluno.logradouro = "nul";
        var message = assertThrows(BadRequestException.class, () -> {
            var result = validator.isNaoPodeInserir(aluno);
        }).getMessage();
        assertEquals(message, "O logradouro precisa ter entre 4 a 64 caracteres");
    }

    @Test
    void isNaoPodeInserirLogradouroForMaiorQue64Caracteres() {
        aluno.logradouro = "Rua das Pacas, condiminio gravata 2 - quadra 20 lote 1100 - Cabo Frio - Rio de Janeiro";
        var message = assertThrows(BadRequestException.class, () -> {
            var result = validator.isNaoPodeInserir(aluno);
        }).getMessage();
        assertEquals(message, "O logradouro precisa ter entre 4 a 64 caracteres");
    }

    @Test
    void isNaoPodeInserirSeCepForNulo() {
        aluno.cep = null;
        var message = assertThrows(BadRequestException.class, () -> {
            var result = validator.isNaoPodeInserir(aluno);
        }).getMessage();
        assertEquals(message, "O cep está nulo ou vazio");
    }

    @Test
    void isNaoPodeInserirSeCepForDiferenteDe8Caracteres() {
        aluno.cep = "0088";
        var message = assertThrows(BadRequestException.class, () -> {
            var result = validator.isNaoPodeInserir(aluno);
        }).getMessage();
        assertEquals(message, "O tamanho do CEP deve ter 8 caracteres");
    }

    @Test
    void isNaoPodeInserirSeBairroForNulo() {
        aluno.bairro = null;
        var message = assertThrows(BadRequestException.class, () -> {
            var result = validator.isNaoPodeInserir(aluno);
        }).getMessage();
        assertEquals(message, "O bairro esta nulo ou vazio");
    }

    @Test
    void isNaoPodeInserirSeBairroForVazio() {
        aluno.bairro = "";
        var message = assertThrows(BadRequestException.class, () -> {
            var result = validator.isNaoPodeInserir(aluno);
        }).getMessage();
        assertEquals(message, "O bairro esta nulo ou vazio");
    }

    @Test
    void isNaoPodeInserirSeBairroForMenorQue3Caracteres() {
        aluno.bairro = "nu";
        var message = assertThrows(BadRequestException.class, () -> {
            var result = validator.isNaoPodeInserir(aluno);
        }).getMessage();
        assertEquals(message, "O bairro precisa ter entre 4 a 64 caracteres");
    }

    @Test
    void isNaoPodeInserirSeBairroForMaiorQue64Caracteres() {
        aluno.bairro = "PindamonhagabivectstarpudvksPindamonhagabivectstarpudvksPindamonhagabivectstar";
        var message = assertThrows(BadRequestException.class, () -> {
            var result = validator.isNaoPodeInserir(aluno);
        }).getMessage();
        assertEquals(message, "O bairro precisa ter entre 4 a 64 caracteres");
    }

    @Test
    void isNaoPodeInserirCidadeForNulo() {
        aluno.cidade = null;
        var message = assertThrows(BadRequestException.class, () -> {
            var result = validator.isNaoPodeInserir(aluno);
        }).getMessage();
        assertEquals(message, "A cidade esta nulo ou vazio");
    }

    @Test
    void isNaoPodeInserirCidadeForVazio() {
        aluno.cidade = "";
        var message = assertThrows(BadRequestException.class, () -> {
            var result = validator.isNaoPodeInserir(aluno);
        }).getMessage();
        assertEquals(message, "A cidade esta nulo ou vazio");
    }

    @Test
    void isNaoPodeInserirCidadeForMenorQue3Caracteres() {
        aluno.cidade = "qw";
        var message = assertThrows(BadRequestException.class, () -> {
            var result = validator.isNaoPodeInserir(aluno);
        }).getMessage();
        assertEquals(message, "A cidade precisa ter entre 4 a 64 caracteres");
    }

    @Test
    void isNaoPodeInserirCidadeForMaiorQue64Caracteres() {
        aluno.cidade = "PindamonhagabivectstarpudvksPindamonhagabivectstarpudvksPindamonhagabivectstar";
        var message = assertThrows(BadRequestException.class, () -> {
            var result = validator.isNaoPodeInserir(aluno);
        }).getMessage();
        assertEquals(message, "A cidade precisa ter entre 4 a 64 caracteres");
    }

    @Test
    void isNaoPodeInserirEstadoForNulo() {
        aluno.estado = null;
        var message = assertThrows(BadRequestException.class, () -> {
            var result = validator.isNaoPodeInserir(aluno);
        }).getMessage();
        assertEquals(message, "O estado esta nulo ou vazio");
    }

    @Test
    void isNaoPodeInserirEstadoForVazio() {
        aluno.estado = "";
        var message = assertThrows(BadRequestException.class, () -> {
            var result = validator.isNaoPodeInserir(aluno);
        }).getMessage();
        assertEquals(message, "O estado esta nulo ou vazio");
    }

    @Test
    void isNaoPodeInserirEstadoForMenorQue3Caracteres() {
        aluno.estado = "nu";
        var message = assertThrows(BadRequestException.class, () -> {
            var result = validator.isNaoPodeInserir(aluno);
        }).getMessage();
        assertEquals(message, "O estado precisa ter entre 3 a 64 caracteres");
    }

    @Test
    void isNaoPodeInserirEstadoForMaiorQue64Caracteres() {
        aluno.estado = "PindamonhagabivectstarpudvksPindamonhagabivectstarpudvksPindamonhagabivectstar";
        var message = assertThrows(BadRequestException.class, () -> {
            var result = validator.isNaoPodeInserir(aluno);
        }).getMessage();
        assertEquals(message, "O estado precisa ter entre 3 a 64 caracteres");
    }






    //Atualização do usuário


    @Test
    void atualizaUsuarioComSucesso() {
        var result = validator.isNaoPodeAtualizar(atualizaAluno);
        Assertions.assertFalse(result);
    }

    @Test
    void isNaoPodeAtualizarSeIdForNulo() {
        atualizaAluno.id = null;
        var message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeAtualizar(atualizaAluno);
        }).getMessage();
        assertEquals("O aluno precisa de um Id", message);
    }

    @Test
    void isNaoPodeAtualizarSeNomeForNulo() {
        atualizaAluno.nome = null;
        var message = assertThrows(BadRequestException.class, () -> {
            var result = validator.isNaoPodeAtualizar(atualizaAluno);
        }).getMessage();
        assertEquals("O nome esta nulo ou vazio", message);
    }

    @Test
    void isNaoPodeAtualizarSeNomeForVazio() {
        atualizaAluno.nome = "";
        var message = assertThrows(BadRequestException.class, () -> {
            var result = validator.isNaoPodeAtualizar(atualizaAluno);
        }).getMessage();
        assertEquals("O nome esta nulo ou vazio", message);
    }

    @Test
    void isNaoPodeAtualizarSeNomeForMenorQue10Caracteres() {
        atualizaAluno.nome = "Thiago";
        var message = assertThrows(BadRequestException.class, () -> {
            var result = validator.isNaoPodeAtualizar(atualizaAluno);
        }).getMessage();
        assertEquals("O nome precisa ter entre 10 a 64 caracteres", message);
    }

    @Test
    void isNaoPodeAtualizarSeNomeForMaiorQue64Caracteres() {
        atualizaAluno.nome = "Thiago dos Santos Celestino da Cunha Thiago dos Santos Celestino ";
        var message = assertThrows(BadRequestException.class, () -> {
            var result = validator.isNaoPodeAtualizar(atualizaAluno);
        }).getMessage();
        assertEquals("O nome precisa ter entre 10 a 64 caracteres", message);
    }

    @Test
    void isNaoPodeAtualizarSeDataDeNascimentoForNulo() {
        atualizaAluno.dataNascimento = null;
        var message = assertThrows(BadRequestException.class, () -> {
            var result = validator.isNaoPodeAtualizar(atualizaAluno);
        }).getMessage();
        assertEquals("A data de nascimento esta nula ou vázia", message);
    }

    @Test
    void isNaoPodeAtualizarSeDataDeNascimentoForVazio() {
        atualizaAluno.dataNascimento = "";
        Assertions.assertThrows(BadRequestException.class, () -> {
            var result = validator.isNaoPodeAtualizar(atualizaAluno);
        });
    }

    @Test
    void isNaoPodeAtualizarSeDataNascimentoTiverFormatoInvalido() {
        atualizaAluno.dataNascimento = "19/09/1789";
        Assertions.assertThrows(BadRequestException.class, () -> {
            var result = validator.isNaoPodeAtualizar(atualizaAluno);
        });
    }

    @Test
    void isNaoPodeAtualizarLogradouroForNulo() {
        atualizaAluno.logradouro = null;
        var message = assertThrows(BadRequestException.class, () -> {
            var result = validator.isNaoPodeAtualizar(atualizaAluno);
        }).getMessage();
        assertEquals(message, "O logradouro esta nulo ou vazio");
    }

    @Test
    void isNaoPodeAtualizarLogradouroForVazio() {
        atualizaAluno.logradouro = "";
        var message = assertThrows(BadRequestException.class, () -> {
            var result = validator.isNaoPodeAtualizar(atualizaAluno);
        }).getMessage();
        assertEquals(message, "O logradouro esta nulo ou vazio");
    }

    @Test
    void isNaoPodeAtualizarLogradouroForMenorQue4Caracteres() {
        atualizaAluno.logradouro = "nul";
        var message = assertThrows(BadRequestException.class, () -> {
            var result = validator.isNaoPodeAtualizar(atualizaAluno);
        }).getMessage();
        assertEquals(message, "O logradouro precisa ter entre 4 a 64 caracteres");
    }

    @Test
    void isNaoPodeAtualizarLogradouroForMaiorQue64Caracteres() {
        atualizaAluno.logradouro = "Rua das Pacas, condiminio gravata 2 - quadra 20 lote 1100 - Cabo Frio - Rio de Janeiro";
        var message = assertThrows(BadRequestException.class, () -> {
            var result = validator.isNaoPodeAtualizar(atualizaAluno);
        }).getMessage();
        assertEquals(message, "O logradouro precisa ter entre 4 a 64 caracteres");
    }

    @Test
    void isNaoPodeAtualizarSeCepForNulo() {
        atualizaAluno.cep = null;
        var message = assertThrows(BadRequestException.class, () -> {
            var result = validator.isNaoPodeAtualizar(atualizaAluno);
        }).getMessage();
        assertEquals(message, "O cep está nulo ou vazio");
    }

    @Test
    void isNaoPodeAtualizarSeCepForDiferenteDe8Caracteres() {
        atualizaAluno.cep = "0088";
        var message = assertThrows(BadRequestException.class, () -> {
            var result = validator.isNaoPodeAtualizar(atualizaAluno);
        }).getMessage();
        assertEquals(message, "O tamanho do CEP deve ter 8 caracteres");
    }

    @Test
    void isNaoPodeAtualizarSeBairroForNulo() {
        atualizaAluno.bairro = null;
        var message = assertThrows(BadRequestException.class, () -> {
            var result = validator.isNaoPodeAtualizar(atualizaAluno);
        }).getMessage();
        assertEquals(message, "O bairro esta nulo ou vazio");
    }

    @Test
    void isNaoPodeAtualizarSeBairroForVazio() {
        atualizaAluno.bairro = "";
        var message = assertThrows(BadRequestException.class, () -> {
            var result = validator.isNaoPodeAtualizar(atualizaAluno);
        }).getMessage();
        assertEquals(message, "O bairro esta nulo ou vazio");
    }

    @Test
    void isNaoPodeAtualizarSeBairroForMenorQue3Caracteres() {
        atualizaAluno.bairro = "nu";
        var message = assertThrows(BadRequestException.class, () -> {
            var result = validator.isNaoPodeAtualizar(atualizaAluno);
        }).getMessage();
        assertEquals(message, "O bairro precisa ter entre 4 a 64 caracteres");
    }

    @Test
    void isNaoPodeAtualizarSeBairroForMaiorQue64Caracteres() {
        atualizaAluno.bairro = "PindamonhagabivectstarpudvksPindamonhagabivectstarpudvksPindamonhagabivectstar";
        var message = assertThrows(BadRequestException.class, () -> {
            var result = validator.isNaoPodeAtualizar(atualizaAluno);
        }).getMessage();
        assertEquals(message, "O bairro precisa ter entre 4 a 64 caracteres");
    }

    @Test
    void isNaoPodeAtualizarCidadeForNulo() {
        atualizaAluno.cidade = null;
        var message = assertThrows(BadRequestException.class, () -> {
            var result = validator.isNaoPodeAtualizar(atualizaAluno);
        }).getMessage();
        assertEquals(message, "A cidade esta nulo ou vazio");
    }

    @Test
    void isNaoPodeAtualizarCidadeForVazio() {
        atualizaAluno.cidade = "";
        var message = assertThrows(BadRequestException.class, () -> {
            var result = validator.isNaoPodeAtualizar(atualizaAluno);
        }).getMessage();
        assertEquals(message, "A cidade esta nulo ou vazio");
    }

    @Test
    void isNaoPodeAtualizarCidadeForMenorQue3Caracteres() {
        atualizaAluno.cidade = "qw";
        var message = assertThrows(BadRequestException.class, () -> {
            var result = validator.isNaoPodeAtualizar(atualizaAluno);
        }).getMessage();
        assertEquals(message, "A cidade precisa ter entre 4 a 64 caracteres");
    }

    @Test
    void isNaoPodeAtualizarCidadeForMaiorQue64Caracteres() {
        atualizaAluno.cidade = "PindamonhagabivectstarpudvksPindamonhagabivectstarpudvksPindamonhagabivectstar";
        var message = assertThrows(BadRequestException.class, () -> {
            var result = validator.isNaoPodeAtualizar(atualizaAluno);
        }).getMessage();
        assertEquals(message, "A cidade precisa ter entre 4 a 64 caracteres");
    }

    @Test
    void isNaoPodeAtualizarEstadoForNulo() {
        atualizaAluno.estado = null;
        var message = assertThrows(BadRequestException.class, () -> {
            var result = validator.isNaoPodeAtualizar(atualizaAluno);
        }).getMessage();
        assertEquals(message, "O estado esta nulo ou vazio");
    }

    @Test
    void isNaoPodeAtualizarEstadoForVazio() {
        atualizaAluno.estado = "";
        var message = assertThrows(BadRequestException.class, () -> {
            var result = validator.isNaoPodeAtualizar(atualizaAluno);
        }).getMessage();
        assertEquals(message, "O estado esta nulo ou vazio");
    }

    @Test
    void isNaoPodeAtualizarEstadoForMenorQue3Caracteres() {
        atualizaAluno.estado = "nu";
        var message = assertThrows(BadRequestException.class, () -> {
            var result = validator.isNaoPodeAtualizar(atualizaAluno);
        }).getMessage();
        assertEquals(message, "O estado precisa ter entre 3 a 64 caracteres");
    }

    @Test
    void isNaoPodeAtualizarEstadoForMaiorQue64Caracteres() {
        atualizaAluno.estado = "PindamonhagabivectstarpudvksPindamonhagabivectstarpudvksPindamonhagabivectstar";
        var message = assertThrows(BadRequestException.class, () -> {
            var result = validator.isNaoPodeAtualizar(atualizaAluno);
        }).getMessage();
        assertEquals(message, "O estado precisa ter entre 3 a 64 caracteres");
    }

    @Test
    void isNaoPodeAtualizarSePessoaNaoExiste() {
        atualizaAluno.id = 171771717171L;
        var message = assertThrows(NotFoundException.class, () -> {
            var result = validator.isNaoPodeAtualizar(atualizaAluno);
        }).getMessage();
        assertEquals(message, "O usuário que você esta tentado atualizar não existe");
    }




    // Não Pode buscar

    @Test
    void isNaoPodeBuscarSeNaoTemUsuario() {
        Long id = -1L;
        var message = assertThrows(NotFoundException.class, () -> {
            var result = validator.isNaoPodeBuscarPorId(id);
        }).getMessage();
        assertEquals(message, "Este aluno não esta cadastrado em nossa base de dados");
    }



    // Não Pode buscar

    @Test
    void isNaoPodeRemoverSeNaoTemUsuario() {
        Long id = -1L;
        var message = assertThrows(NotFoundException.class, () -> {
            var result = validator.isNaoPodeBuscarPorId(id);
        }).getMessage();
        assertEquals(message, "Este aluno não esta cadastrado em nossa base de dados");
    }

}