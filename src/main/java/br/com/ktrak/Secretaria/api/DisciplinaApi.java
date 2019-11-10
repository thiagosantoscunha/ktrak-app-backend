package br.com.ktrak.secretaria.api;

import br.com.ktrak.domain.dto.AtualizaDisciplinaDto;
import br.com.ktrak.domain.dto.ExibeDisciplinaDto;
import br.com.ktrak.domain.dto.InsereDisciplinaDto;
import br.com.ktrak.domain.services.DisciplinaService;
import br.com.ktrak.secretaria.validators.DisciplinaValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/disciplinas")
public class DisciplinaApi {

    @Autowired
    private DisciplinaService service;

    @Autowired
    private DisciplinaValidator validator;

    @GetMapping
    public ResponseEntity<List<ExibeDisciplinaDto>> buscaTudo() {
        var disciplinas = service.buscaTudo();
        return new ResponseEntity<>(disciplinas, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ExibeDisciplinaDto> insere(@RequestBody InsereDisciplinaDto model) {
        validator.isNaoPodeInserir(model);
        var disciplinaInserida = service.insere(model);
        return new ResponseEntity<>(disciplinaInserida, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ExibeDisciplinaDto> atualiza(@RequestBody AtualizaDisciplinaDto model) {
        validator.isNaoPodeAtualizar(model);
        var disciplinaAtualizada = service.atualiza(model);
        return new ResponseEntity<>(disciplinaAtualizada, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ExibeDisciplinaDto> buscaPorId(@PathVariable("id") Long id) {
        validator.isNaoPodeBuscarPorId(id);
        var disciplina = service.buscaPorId(id);
        return new ResponseEntity<>(disciplina, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> remove(@RequestParam(name = "id") Long id) {
        validator.isNaoPodeRemover(id);
        service.removePorId(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
