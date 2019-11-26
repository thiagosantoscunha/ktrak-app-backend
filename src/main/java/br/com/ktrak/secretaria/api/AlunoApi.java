package br.com.ktrak.secretaria.api;

import br.com.ktrak.domain.dto.AlunoDto;
import br.com.ktrak.domain.dto.TurmaDto;
import br.com.ktrak.domain.dto.in.AtualizaAlunoDto;
import br.com.ktrak.domain.dto.out.ExibeAlunoDto;
import br.com.ktrak.domain.dto.in.InsereAlunoDto;
import br.com.ktrak.domain.entities.AlunoEntity;
import br.com.ktrak.domain.services.AlunoService;
import br.com.ktrak.secretaria.validators.AlunoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
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
        return new ResponseEntity<>(alunoService.buscaTudo(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<AlunoDto> buscaPorId(@PathVariable(name = "id") Long id) {
        validator.isNaoPodeBuscarPorId(id);
        return new ResponseEntity<>(alunoService.buscaPorId(id), HttpStatus.OK);
    }

    @GetMapping(path = "/filter")
    public ResponseEntity<List<AlunoDto>> buscaTudoPorNome(@RequestParam("nome") String nome) {
        validator.isNaoPodeBuscarPorNome(nome);
        return ResponseEntity.ok(alunoService.buscaTudoPorNome(nome));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<AlunoDto> insere(@RequestBody AlunoDto dto) {
        validator.isNaoPodeInserir(dto);
        return new ResponseEntity<>(alunoService.insere(dto), HttpStatus.OK);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<AlunoDto> atualiza(@RequestBody AlunoDto dto) {
        validator.isNaoPodeAtualizar(dto);
        return new ResponseEntity<>(alunoService.atualiza(dto), HttpStatus.OK);
    }

    @DeleteMapping(params = "id")
    public ResponseEntity<?> remove(@RequestParam String id) {
        Long idParsed = Long.parseLong(id);
        validator.isNaoPodeRemover(idParsed);
        alunoService.remove(idParsed);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
