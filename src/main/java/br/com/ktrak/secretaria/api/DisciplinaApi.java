package br.com.ktrak.secretaria.api;

import br.com.ktrak.secretaria.validators.DisciplinaValidator;
import br.com.ktrak.domain.dto.DisciplinaDto;
import br.com.ktrak.domain.services.DisciplinaService;
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
    public ResponseEntity<List<DisciplinaDto>> buscaTudo() {
        return new ResponseEntity<>(service.buscaTudo(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DisciplinaDto> insere(@RequestBody DisciplinaDto dto) {
        validator.isNaoPodeInserir(dto);
        return new ResponseEntity<>(service.insere(dto), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<DisciplinaDto> atualiza(@RequestBody DisciplinaDto dto) {
        validator.isNaoPodeAtualizar(dto);
        return new ResponseEntity<>(service.atualiza(dto), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<DisciplinaDto> buscaPorId(@PathVariable("id") Long id) {
        validator.isNaoPodeBuscarPorId(id);
        return new ResponseEntity<>(service.buscaPorId(id), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> remove(@RequestParam(name = "id") Long id) {
        validator.isNaoPodeRemover(id);
        service.removePorId(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
