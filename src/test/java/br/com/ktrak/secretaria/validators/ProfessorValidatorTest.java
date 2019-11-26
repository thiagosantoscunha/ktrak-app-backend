package br.com.ktrak.secretaria.validators;

import br.com.ktrak.domain.dto.ProfessorDto;
import br.com.ktrak.domain.dto.in.InsereProfessorDto;
import br.com.ktrak.domain.exceptions.BadRequestException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProfessorValidatorTest {

    @Autowired
    ProfessorValidator validator;

    ProfessorDto professor;

    @BeforeEach
    void setUp() {
        professor = new ProfessorDto();
        professor.nome = "Caio Ferreira Mestre dos Magos";
        professor.cep = "20200000";
        professor.logradouro = "Rua das Pacas, cond GI";
        professor.dataNascimento = "19-10-1993";
        professor.bairro = "Campo do Oeste";
        professor.cidade = "Macaé";
        professor.estado = "Rio de Janeiro";
    }

    @Test
    void isNaoPodeInserirSeNomeForNulo() {
        professor.nome = null;
        String message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeInserir(professor);
        }).getMessage();
        assertEquals("O nome do professor não pode ser nulo ou vazio", message);
    }

    @Test
    void isNaoPodeInserirSeNomeForVazio() {
        professor.nome = "";
        String message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeInserir(professor);
        }).getMessage();
        assertEquals("O nome do professor não pode ser nulo ou vazio", message);
    }

    @Test
    void isNaoPodeInserirSeNomeForMenorQue10Caracteres() {
        professor.nome = "Thiago";
        String message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeInserir(professor);
        }).getMessage();
        assertEquals("O nome precisa ter entre 10 a 64 caracteres", message);
    }

    @Test
    void isNaoPodeInserirSeNomeForMaiorQue64Caracteres() {
        professor.nome = "Thiago dos Santos Celestino da Cunha Thiago dos Santos Celestino ";
        String message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeInserir(professor);
        }).getMessage();
        assertEquals("O nome precisa ter entre 10 a 64 caracteres", message);
    }

    @Test
    void isNaoPodeInserirSeDataDeNascimentoForNulo() {
        professor.dataNascimento = null;
        String message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeInserir(professor);
        }).getMessage();
        assertEquals("A data de nascimento esta nula ou vázia", message);
    }

    @Test
    void isNaoPodeInserirSeDataDeNascimentoForVazio() {
        professor.dataNascimento = "";
        String message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeInserir(professor);
        }).getMessage();
        assertEquals("A data de nascimento esta nula ou vázia", message);
    }

    @Test
    void isNaoPodeInserirSeDataNascimentoTiverFormatoInvalido() {
        professor.dataNascimento = "19/09/1789";
        String message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeInserir(professor);
        }).getMessage();
        assertEquals(message, "O formato da data é inválido.");
    }

    @Test
    void isNaoPodeInserirLogradouroForNulo() {
        professor.logradouro = null;
        String message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeInserir(professor);
        }).getMessage();
        assertEquals(message, "O logradouro esta nulo ou vazio");
    }

    @Test
    void isNaoPodeInserirLogradouroForVazio() {
        professor.logradouro = "";
        String message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeInserir(professor);
        }).getMessage();
        assertEquals(message, "O logradouro esta nulo ou vazio");
    }

    @Test
    void isNaoPodeInserirLogradouroForMenorQue4Caracteres() {
        professor.logradouro = "nul";
        String message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeInserir(professor);
        }).getMessage();
        assertEquals(message, "O logradouro precisa ter entre 4 a 64 caracteres");
    }

    @Test
    void isNaoPodeInserirLogradouroForMaiorQue64Caracteres() {
        professor.logradouro = "Rua das Pacas, condiminio gravata 2 - quadra 20 lote 1100 - Cabo Frio - Rio de Janeiro";
        String message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeInserir(professor);
        }).getMessage();
        assertEquals(message, "O logradouro precisa ter entre 4 a 64 caracteres");
    }

    @Test
    void isNaoPodeInserirSeCepForNulo() {
        professor.cep = null;
        String message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeInserir(professor);
        }).getMessage();
        assertEquals(message, "O cep está nulo ou vazio");
    }

    @Test
    void isNaoPodeInserirSeCepForVazio() {
        professor.cep = "";
        String message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeInserir(professor);
        }).getMessage();
        assertEquals(message, "O cep está nulo ou vazio");
    }

    @Test
    void isNaoPodeInserirSeCepForDiferenteDe8Caracteres() {
        professor.cep = "0088";
        String message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeInserir(professor);
        }).getMessage();
        assertEquals(message, "O tamanho do CEP deve ter 8 caracteres");
    }

    @Test
    void isNaoPodeInserirSeBairroForNulo() {
        professor.bairro = null;
        String message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeInserir(professor);
        }).getMessage();
        assertEquals(message, "O bairro esta nulo ou vazio");
    }

    @Test
    void isNaoPodeInserirSeBairroForVazio() {
        professor.bairro = "";
        String message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeInserir(professor);
        }).getMessage();
        assertEquals(message, "O bairro esta nulo ou vazio");
    }

    @Test
    void isNaoPodeInserirSeBairroForMenorQue3Caracteres() {
        professor.bairro = "nu";
        String message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeInserir(professor);
        }).getMessage();
        assertEquals(message, "O bairro precisa ter entre 4 a 64 caracteres");
    }

    @Test
    void isNaoPodeInserirSeBairroForMaiorQue64Caracteres() {
        professor.bairro = "PindamonhagabivectstarpudvksPindamonhagabivectstarpudvksPindamonhagabivectstar";
        String message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeInserir(professor);
        }).getMessage();
        assertEquals(message, "O bairro precisa ter entre 4 a 64 caracteres");
    }

    @Test
    void isNaoPodeInserirCidadeForNulo() {
        professor.cidade = null;
        String message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeInserir(professor);
        }).getMessage();
        assertEquals(message, "A cidade esta nulo ou vazio");
    }

    @Test
    void isNaoPodeInserirCidadeForVazio() {
        professor.cidade = "";
        String message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeInserir(professor);
        }).getMessage();
        assertEquals(message, "A cidade esta nulo ou vazio");
    }

    @Test
    void isNaoPodeInserirCidadeForMenorQue3Caracteres() {
        professor.cidade = "qw";
        String message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeInserir(professor);
        }).getMessage();
        assertEquals(message, "A cidade precisa ter entre 4 a 64 caracteres");
    }

    @Test
    void isNaoPodeInserirCidadeForMaiorQue64Caracteres() {
        professor.cidade = "PindamonhagabivectstarpudvksPindamonhagabivectstarpudvksPindamonhagabivectstar";
        String message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeInserir(professor);
        }).getMessage();
        assertEquals(message, "A cidade precisa ter entre 4 a 64 caracteres");
    }

    @Test
    void isNaoPodeInserirEstadoForNulo() {
        professor.estado = null;
        String message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeInserir(professor);
        }).getMessage();
        assertEquals(message, "O estado esta nulo ou vazio");
    }

    @Test
    void isNaoPodeInserirEstadoForVazio() {
        professor.estado = "";
        String message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeInserir(professor);
        }).getMessage();
        assertEquals(message, "O estado esta nulo ou vazio");
    }

    @Test
    void isNaoPodeInserirEstadoForMenorQue3Caracteres() {
        professor.estado = "nu";
        String message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeInserir(professor);
        }).getMessage();
        assertEquals(message, "O estado precisa ter entre 3 a 64 caracteres");
    }

    @Test
    void isNaoPodeInserirEstadoForMaiorQue64Caracteres() {
        professor.estado = "PindamonhagabivectstarpudvksPindamonhagabivectstarpudvksPindamonhagabivectstar";
        String message = assertThrows(BadRequestException.class, () -> {
            validator.isNaoPodeInserir(professor);
        }).getMessage();
        assertEquals(message, "O estado precisa ter entre 3 a 64 caracteres");
    }






    //Atualização do usuário

//
//    @Test
//    void atualizaUsuarioComSucesso() {
//        String result = validator.isNaoPodeAtualizar(atualizaAluno);
//        Assertions.assertFalse(result);
//    }
//
//    @Test
//    void isNaoPodeAtualizarSeIdForNulo() {
//        atualizaAluno.id = null;
//        String message = assertThrows(BadRequestException.class, () -> {
//            validator.isNaoPodeAtualizar(atualizaAluno);
//        }).getMessage();
//        assertEquals("O aluno precisa de um Id", message);
//    }
//
//    @Test
//    void isNaoPodeAtualizarSeNomeForNulo() {
//        atualizaAluno.nome = null;
//        String message = assertThrows(BadRequestException.class, () -> {
//            validator.isNaoPodeAtualizar(atualizaAluno);
//        }).getMessage();
//        assertEquals("O nome esta nulo ou vazio", message);
//    }
//
//    @Test
//    void isNaoPodeAtualizarSeNomeForVazio() {
//        atualizaAluno.nome = "";
//        String message = assertThrows(BadRequestException.class, () -> {
//            validator.isNaoPodeAtualizar(atualizaAluno);
//        }).getMessage();
//        assertEquals("O nome esta nulo ou vazio", message);
//    }
//
//    @Test
//    void isNaoPodeAtualizarSeNomeForMenorQue10Caracteres() {
//        atualizaAluno.nome = "Thiago";
//        String message = assertThrows(BadRequestException.class, () -> {
//            validator.isNaoPodeAtualizar(atualizaAluno);
//        }).getMessage();
//        assertEquals("O nome precisa ter entre 10 a 64 caracteres", message);
//    }
//
//    @Test
//    void isNaoPodeAtualizarSeNomeForMaiorQue64Caracteres() {
//        atualizaAluno.nome = "Thiago dos Santos Celestino da Cunha Thiago dos Santos Celestino ";
//        String message = assertThrows(BadRequestException.class, () -> {
//            validator.isNaoPodeAtualizar(atualizaAluno);
//        }).getMessage();
//        assertEquals("O nome precisa ter entre 10 a 64 caracteres", message);
//    }
//
//    @Test
//    void isNaoPodeAtualizarSeDataDeNascimentoForNulo() {
//        atualizaAluno.dataNascimento = null;
//        String message = assertThrows(BadRequestException.class, () -> {
//            validator.isNaoPodeAtualizar(atualizaAluno);
//        }).getMessage();
//        assertEquals("A data de nascimento esta nula ou vázia", message);
//    }
//
//    @Test
//    void isNaoPodeAtualizarSeDataDeNascimentoForVazio() {
//        atualizaAluno.dataNascimento = "";
//        Assertions.assertThrows(BadRequestException.class, () -> {
//            validator.isNaoPodeAtualizar(atualizaAluno);
//        });
//    }
//
//    @Test
//    void isNaoPodeAtualizarSeDataNascimentoTiverFormatoInvalido() {
//        atualizaAluno.dataNascimento = "19/09/1789";
//        Assertions.assertThrows(BadRequestException.class, () -> {
//            validator.isNaoPodeAtualizar(atualizaAluno);
//        });
//    }
//
//    @Test
//    void isNaoPodeAtualizarLogradouroForNulo() {
//        atualizaAluno.logradouro = null;
//        String message = assertThrows(BadRequestException.class, () -> {
//            validator.isNaoPodeAtualizar(atualizaAluno);
//        }).getMessage();
//        assertEquals(message, "O logradouro esta nulo ou vazio");
//    }
//
//    @Test
//    void isNaoPodeAtualizarLogradouroForVazio() {
//        atualizaAluno.logradouro = "";
//        String message = assertThrows(BadRequestException.class, () -> {
//            validator.isNaoPodeAtualizar(atualizaAluno);
//        }).getMessage();
//        assertEquals(message, "O logradouro esta nulo ou vazio");
//    }
//
//    @Test
//    void isNaoPodeAtualizarLogradouroForMenorQue4Caracteres() {
//        atualizaAluno.logradouro = "nul";
//        String message = assertThrows(BadRequestException.class, () -> {
//            validator.isNaoPodeAtualizar(atualizaAluno);
//        }).getMessage();
//        assertEquals(message, "O logradouro precisa ter entre 4 a 64 caracteres");
//    }
//
//    @Test
//    void isNaoPodeAtualizarLogradouroForMaiorQue64Caracteres() {
//        atualizaAluno.logradouro = "Rua das Pacas, condiminio gravata 2 - quadra 20 lote 1100 - Cabo Frio - Rio de Janeiro";
//        String message = assertThrows(BadRequestException.class, () -> {
//            validator.isNaoPodeAtualizar(atualizaAluno);
//        }).getMessage();
//        assertEquals(message, "O logradouro precisa ter entre 4 a 64 caracteres");
//    }
//
//    @Test
//    void isNaoPodeAtualizarSeCepForNulo() {
//        atualizaAluno.cep = null;
//        String message = assertThrows(BadRequestException.class, () -> {
//            validator.isNaoPodeAtualizar(atualizaAluno);
//        }).getMessage();
//        assertEquals(message, "O cep está nulo ou vazio");
//    }
//
//    @Test
//    void isNaoPodeAtualizarSeCepForDiferenteDe8Caracteres() {
//        atualizaAluno.cep = "0088";
//        String message = assertThrows(BadRequestException.class, () -> {
//            validator.isNaoPodeAtualizar(atualizaAluno);
//        }).getMessage();
//        assertEquals(message, "O tamanho do CEP deve ter 8 caracteres");
//    }
//
//    @Test
//    void isNaoPodeAtualizarSeBairroForNulo() {
//        atualizaAluno.bairro = null;
//        String message = assertThrows(BadRequestException.class, () -> {
//            validator.isNaoPodeAtualizar(atualizaAluno);
//        }).getMessage();
//        assertEquals(message, "O bairro esta nulo ou vazio");
//    }
//
//    @Test
//    void isNaoPodeAtualizarSeBairroForVazio() {
//        atualizaAluno.bairro = "";
//        String message = assertThrows(BadRequestException.class, () -> {
//            validator.isNaoPodeAtualizar(atualizaAluno);
//        }).getMessage();
//        assertEquals(message, "O bairro esta nulo ou vazio");
//    }
//
//    @Test
//    void isNaoPodeAtualizarSeBairroForMenorQue3Caracteres() {
//        atualizaAluno.bairro = "nu";
//        String message = assertThrows(BadRequestException.class, () -> {
//            validator.isNaoPodeAtualizar(atualizaAluno);
//        }).getMessage();
//        assertEquals(message, "O bairro precisa ter entre 4 a 64 caracteres");
//    }
//
//    @Test
//    void isNaoPodeAtualizarSeBairroForMaiorQue64Caracteres() {
//        atualizaAluno.bairro = "PindamonhagabivectstarpudvksPindamonhagabivectstarpudvksPindamonhagabivectstar";
//        String message = assertThrows(BadRequestException.class, () -> {
//            validator.isNaoPodeAtualizar(atualizaAluno);
//        }).getMessage();
//        assertEquals(message, "O bairro precisa ter entre 4 a 64 caracteres");
//    }
//
//    @Test
//    void isNaoPodeAtualizarCidadeForNulo() {
//        atualizaAluno.cidade = null;
//        String message = assertThrows(BadRequestException.class, () -> {
//            validator.isNaoPodeAtualizar(atualizaAluno);
//        }).getMessage();
//        assertEquals(message, "A cidade esta nulo ou vazio");
//    }
//
//    @Test
//    void isNaoPodeAtualizarCidadeForVazio() {
//        atualizaAluno.cidade = "";
//        String message = assertThrows(BadRequestException.class, () -> {
//            validator.isNaoPodeAtualizar(atualizaAluno);
//        }).getMessage();
//        assertEquals(message, "A cidade esta nulo ou vazio");
//    }
//
//    @Test
//    void isNaoPodeAtualizarCidadeForMenorQue3Caracteres() {
//        atualizaAluno.cidade = "qw";
//        String message = assertThrows(BadRequestException.class, () -> {
//            validator.isNaoPodeAtualizar(atualizaAluno);
//        }).getMessage();
//        assertEquals(message, "A cidade precisa ter entre 4 a 64 caracteres");
//    }
//
//    @Test
//    void isNaoPodeAtualizarCidadeForMaiorQue64Caracteres() {
//        atualizaAluno.cidade = "PindamonhagabivectstarpudvksPindamonhagabivectstarpudvksPindamonhagabivectstar";
//        String message = assertThrows(BadRequestException.class, () -> {
//            validator.isNaoPodeAtualizar(atualizaAluno);
//        }).getMessage();
//        assertEquals(message, "A cidade precisa ter entre 4 a 64 caracteres");
//    }
//
//    @Test
//    void isNaoPodeAtualizarEstadoForNulo() {
//        atualizaAluno.estado = null;
//        String message = assertThrows(BadRequestException.class, () -> {
//            validator.isNaoPodeAtualizar(atualizaAluno);
//        }).getMessage();
//        assertEquals(message, "O estado esta nulo ou vazio");
//    }
//
//    @Test
//    void isNaoPodeAtualizarEstadoForVazio() {
//        atualizaAluno.estado = "";
//        String message = assertThrows(BadRequestException.class, () -> {
//            validator.isNaoPodeAtualizar(atualizaAluno);
//        }).getMessage();
//        assertEquals(message, "O estado esta nulo ou vazio");
//    }
//
//    @Test
//    void isNaoPodeAtualizarEstadoForMenorQue3Caracteres() {
//        atualizaAluno.estado = "nu";
//        String message = assertThrows(BadRequestException.class, () -> {
//            validator.isNaoPodeAtualizar(atualizaAluno);
//        }).getMessage();
//        assertEquals(message, "O estado precisa ter entre 3 a 64 caracteres");
//    }
//
//    @Test
//    void isNaoPodeAtualizarEstadoForMaiorQue64Caracteres() {
//        atualizaAluno.estado = "PindamonhagabivectstarpudvksPindamonhagabivectstarpudvksPindamonhagabivectstar";
//        String message = assertThrows(BadRequestException.class, () -> {
//            validator.isNaoPodeAtualizar(atualizaAluno);
//        }).getMessage();
//        assertEquals(message, "O estado precisa ter entre 3 a 64 caracteres");
//    }
//
//    @Test
//    void isNaoPodeAtualizarSePessoaNaoExiste() {
//        atualizaAluno.id = 171771717171L;
//        String message = assertThrows(NotFoundException.class, () -> {
//            validator.isNaoPodeAtualizar(atualizaAluno);
//        }).getMessage();
//        assertEquals(message, "O usuário que você esta tentado atualizar não existe");
//    }
//
//
//
//
//    // Não Pode buscar
//
//    @Test
//    void isNaoPodeBuscarSeNaoTemUsuario() {
//        Long id = -1L;
//        String message = assertThrows(NotFoundException.class, () -> {
//            validator.isNaoPodeBuscarPorId(id);
//        }).getMessage();
//        assertEquals(message, "Este aluno não esta cadastrado em nossa base de dados");
//    }
//
//
//
//    // Não Pode buscar
//
//    @Test
//    void isNaoPodeRemoverSeNaoTemUsuario() {
//        Long id = -1L;
//        String message = assertThrows(NotFoundException.class, () -> {
//            validator.isNaoPodeBuscarPorId(id);
//        }).getMessage();
//        assertEquals(message, "Este aluno não esta cadastrado em nossa base de dados");
//    }
}