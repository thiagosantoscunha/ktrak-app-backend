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
public class MatriculaProfessorApi {

    @Autowired
    private ProfessorService service;

    @Autowired
    private ProfessorValidator validator;

    @GetMapping
    public ResponseEntity<List<ProfessorDto>> buscaTudo() {
        var professores = service.buscaTudo();
        return new ResponseEntity<>(professores, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ProfessorDto> buscaPorId(@PathVariable("id") Long id) {
        validator.naoPodeBuscar(id);
        var professor = service.buscaPorId(id);
        return new ResponseEntity<>(professor, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProfessorDto> insere(@RequestBody ProfessorDto dto) {
        validator.isNaoPodeInserir(dto);
        var professorInserido = service.insere(dto);
        return new ResponseEntity<>(professorInserido, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ProfessorDto> atualiza(@RequestBody ProfessorDto model) {
        validator.isNaoPodeAtualizar(model);
        var professorAtualizado = service.atualiza(model);
        return new ResponseEntity<>(professorAtualizado, HttpStatus.OK);
    }

    @DeleteMapping(params = "id")
    public ResponseEntity<?> remove(@RequestParam String id) {
        Long idParsed = Long.parseLong(id);
        validator.isNaoPodeRemover(idParsed);
        service.remove(idParsed);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

}
