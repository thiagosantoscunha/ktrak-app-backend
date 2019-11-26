package br.com.ktrak.secretaria.api;


import br.com.ktrak.domain.dto.ProfessorDto;
import br.com.ktrak.domain.dto.in.AtualizaProfessorDto;
import br.com.ktrak.domain.dto.out.ExibeProfessorDto;
import br.com.ktrak.domain.dto.in.InsereProfessorDto;
import br.com.ktrak.domain.services.ProfessorService;
import br.com.ktrak.secretaria.validators.ProfessorValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/matriculas/professores")
public class ProfessorApi {

    @Autowired
    private ProfessorService service;

    @Autowired
    private ProfessorValidator validator;

    @GetMapping
    public ResponseEntity<List<ProfessorDto>> buscaTudo() {
        return new ResponseEntity<>(service.buscaTudo(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ProfessorDto> buscaPorId(@PathVariable("id") Long id) {
        validator.naoPodeBuscar(id);
        return new ResponseEntity<>(service.buscaPorId(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProfessorDto> insere(@RequestBody ProfessorDto dto) {
        validator.isNaoPodeInserir(dto);
        return ResponseEntity.ok(service.insere(dto));
    }

    @PutMapping
    public ResponseEntity<ProfessorDto> atualiza(@RequestBody ProfessorDto model) {
        validator.isNaoPodeAtualizar(model);
        return ResponseEntity.ok(service.atualiza(model));
    }

    @DeleteMapping(params = "id")
    public ResponseEntity<?> remove(@RequestParam String id) {
        Long idParsed = Long.parseLong(id);
        validator.isNaoPodeRemover(idParsed);
        service.remove(idParsed);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

}
