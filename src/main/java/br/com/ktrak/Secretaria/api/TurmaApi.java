package br.com.ktrak.secretaria.api;


import br.com.ktrak.domain.dto.InsereTurmaPorSemestreVM;
import br.com.ktrak.domain.dto.SemestreDto;
import br.com.ktrak.domain.dto.TurmaDto;
import br.com.ktrak.domain.dto.in.AtualizaTurmaDto;
import br.com.ktrak.domain.dto.in.InsereTurmaDto;
import br.com.ktrak.domain.dto.out.ExibeTurmaDto;
import br.com.ktrak.domain.services.TurmaService;
import br.com.ktrak.secretaria.validators.SemestreValidation;
import br.com.ktrak.secretaria.validators.TurmaValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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
        var turmas = service.buscaTudo();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("size", turmas.size() + "");
        return ResponseEntity.ok().headers(responseHeaders).body(turmas);
    }

    @PostMapping
    public ResponseEntity<TurmaDto> insere(@RequestBody TurmaDto dto) {
        validation.isNaoPodeInserir(dto);
        var entityInserido = service.insere(dto);
        return new ResponseEntity<>(entityInserido, HttpStatus.OK);
    }

    @PostMapping(path = "/montaTurmaNoSemestre")
    @Transactional
    public ResponseEntity<TurmaDto> montaTurmaNoSemestre(@RequestBody InsereTurmaPorSemestreVM model) {
        validation.isNaoPodeInserir(model.turma);
        var entity = service.insereComSemestre(model.turma, model.semestre);
        return ResponseEntity.ok(entity);
    }

    @PutMapping
    public ResponseEntity<TurmaDto> atualiza(@RequestBody TurmaDto dto) {
        validation.isNaoPodeAtualizar(dto);
        var turmaAtualizada = service.atualiza(dto);
        return new ResponseEntity<>(turmaAtualizada, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Boolean> remove(@PathParam("id") Long id) {
        service.remove(id);
        return ResponseEntity.ok(true);
    }

}

