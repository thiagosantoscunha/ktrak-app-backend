package br.com.ktrak.secretaria.api;

import br.com.ktrak.domain.dto.AlunoDto;
import br.com.ktrak.domain.dto.TurmaDto;
import br.com.ktrak.domain.dto.in.AtualizaAlunoDto;
import br.com.ktrak.domain.dto.out.ExibeAlunoDto;
import br.com.ktrak.domain.dto.in.InsereAlunoDto;
import br.com.ktrak.domain.services.AlunoService;
import br.com.ktrak.secretaria.validators.AlunoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/matriculas/alunos")
public class AlunoApi {

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private AlunoValidator validator;

    @GetMapping
    public ResponseEntity<List<AlunoDto>> buscaTudo() {
        var alunos = alunoService.buscaTudo();
        return new ResponseEntity<>(alunos, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<AlunoDto> buscaPorId(@PathVariable(name = "id") Long id) {
        validator.isNaoPodeBuscarPorId(id);
        var alunoResponse = alunoService.buscaPorId(id);
        return new ResponseEntity<>(alunoResponse, HttpStatus.OK);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<AlunoDto> insere(@RequestBody AlunoDto dto) {
        validator.isNaoPodeInserir(dto);
        var alunoInserido = alunoService.insere(dto);
        return new ResponseEntity<>(alunoInserido, HttpStatus.OK);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<AlunoDto> atualiza(@RequestBody AlunoDto dto) {
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
