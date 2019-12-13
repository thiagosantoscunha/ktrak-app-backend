package com.ktrakapp.secretaria.api;

import com.ktrakapp.domain.dto.InsereTurmaPorSemestreVM;
import com.ktrakapp.domain.dto.TurmaDto;
import com.ktrakapp.domain.services.TurmaService;
import com.ktrakapp.secretaria.validators.SemestreValidation;
import com.ktrakapp.secretaria.validators.TurmaValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(path = "v1/turmas")
public class TurmaApi {

    @Autowired
    private TurmaService service;

    @Autowired
    private TurmaValidation validation;

    @Autowired
    private SemestreValidation semestreValidation;

    @GetMapping
    public ResponseEntity<List<TurmaDto>> buscaTudo() {
        return ResponseEntity.ok(service.buscaTudo());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<TurmaDto> buscaPorId(@PathVariable("id") Long id) {
        TurmaDto response = service.buscaPorId(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping(path = "/alunos/{id}")
    public ResponseEntity<List<TurmaDto>> buscaTudoPorAluno(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.buscaTodasAsTurmasPorIdAluno(id));
    }


    @PostMapping
    public ResponseEntity<TurmaDto> insere(@RequestBody TurmaDto dto) {
        validation.isNaoPodeInserir(dto);
        return ResponseEntity.ok(service.insere(dto));
    }

    @PostMapping(path = "/montaTurmaNoSemestre")
    @Transactional
    public ResponseEntity<TurmaDto> montaTurmaNoSemestre(@RequestBody InsereTurmaPorSemestreVM model) {
        validation.isNaoPodeInserir(model.turma);
        TurmaDto response = service.insereComSemestre(model.turma, model.semestre);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<TurmaDto> atualiza(@RequestBody TurmaDto dto) {
        validation.isNaoPodeAtualizar(dto);
        return ResponseEntity.ok(service.atualiza(dto));
    }

    @DeleteMapping
    public ResponseEntity<Boolean> remove(@PathParam("id") Long id) {
        service.remove(id);
        return ResponseEntity.ok(true);
    }

}

