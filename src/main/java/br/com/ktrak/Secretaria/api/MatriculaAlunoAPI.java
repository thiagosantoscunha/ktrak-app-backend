package br.com.ktrak.secretaria.api;

import br.com.ktrak.domain.dto.AtualizaAlunoDto;
import br.com.ktrak.domain.dto.ExibeAlunoDto;
import br.com.ktrak.domain.dto.InsereAlunoDto;
import br.com.ktrak.domain.repositories.AlunoRepository;
import br.com.ktrak.domain.services.AlunoService;
import br.com.ktrak.secretaria.validators.AlunoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/matriculas/alunos")
public class MatriculaAlunoAPI {

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private AlunoValidator validator;

    @GetMapping
    public ResponseEntity<List<ExibeAlunoDto>> buscaTudo() {
        var alunos = alunoService.buscaTudo();
        return new ResponseEntity<>(alunos, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ExibeAlunoDto> buscaPorId(@PathVariable(name = "id") Long id) {
        validator.isNaoPodeBuscarPorId(id);
        var alunoResponse = alunoService.buscaPorId(id);
        return new ResponseEntity<>(alunoResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ExibeAlunoDto> insere(@RequestBody InsereAlunoDto dto) {
        validator.isNaoPodeInserir(dto);
        var alunoInserido = alunoService.insere(dto);
        return new ResponseEntity<>(alunoInserido, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ExibeAlunoDto> atualiza(@RequestBody AtualizaAlunoDto dto) {
        validator.isNaoPodeAtualizar(dto);
        var alunoAtualizado = alunoService.atualiza(dto);
        return new ResponseEntity<>(alunoAtualizado, HttpStatus.OK);
    }

    @DeleteMapping(params = "id")
    public ResponseEntity<?> remove(@RequestParam String id) {
        Long idParsed = Long.parseLong(id);
        validator.isNaoPodeRemover(idParsed);
        alunoService.remove(idParsed);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
