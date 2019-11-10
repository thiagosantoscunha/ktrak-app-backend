package br.com.ktrak.secretaria.api;


import br.com.ktrak.domain.dto.out.ExibeTurmaDto;
import br.com.ktrak.domain.dto.out.TurmaOutDto;
import br.com.ktrak.domain.entities.ProfessorEntity;
import br.com.ktrak.domain.entities.TurmaEntity;
import br.com.ktrak.domain.services.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "v1/turmas")
public class TurmaApi {

    @Autowired
    private TurmaService service;

    @GetMapping
    public ResponseEntity<List<ExibeTurmaDto>> buscaTudo() {
        var turmas = service.buscaTudo();
        return new ResponseEntity<>(turmas, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TurmaEntity> insere(@RequestBody TurmaEntity entity) {
        var entityInserido = service.insere(entity);
        return new ResponseEntity<>(entityInserido, HttpStatus.OK);
    }

}

