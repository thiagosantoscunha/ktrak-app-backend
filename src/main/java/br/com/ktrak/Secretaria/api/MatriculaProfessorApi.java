package br.com.ktrak.secretaria.api;


import br.com.ktrak.domain.dto.ExibeProfessorDto;
import br.com.ktrak.domain.dto.InsereProfessorDto;
import br.com.ktrak.domain.services.ProfessorService;
import br.com.ktrak.secretaria.validators.ProfessorValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("v1/matriculas/professores")
public class MatriculaProfessorApi {

    @Autowired
    private ProfessorService service;

    @Autowired
    private ProfessorValidator validator;

    @GetMapping
    public ResponseEntity<List<ExibeProfessorDto>> buscaTudo() {
        var professores = service.buscaTudo();
        return new ResponseEntity<>(professores, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ExibeProfessorDto> buscaPorId(@PathVariable("id") Long id) {
        validator.naoPodeBuscar(id);
        var professor = service.buscaPorId(id);
        return new ResponseEntity<>(professor, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ExibeProfessorDto> insere(@RequestBody InsereProfessorDto model) {
        validator.isNaoPodeInserir(model);
        var professorInserido = service.insere(model);
        return new ResponseEntity<>(professorInserido, HttpStatus.OK);
    }

}
