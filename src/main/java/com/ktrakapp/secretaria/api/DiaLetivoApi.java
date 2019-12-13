package com.ktrakapp.secretaria.api;


import com.ktrakapp.domain.dto.DiaLetivoDto;
import com.ktrakapp.domain.dto.TurmaDto;
import com.ktrakapp.domain.services.DiaLetivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(path = "v1/diasLetivos")
public class DiaLetivoApi {

    @Autowired
    private DiaLetivoService service;

    @RequestMapping
    public ResponseEntity<List<DiaLetivoDto>> buscaTudo() {
        return ResponseEntity.ok(service.buscaTudo());
    }

    @RequestMapping(path = "/turmas/{idTurma}")
    public ResponseEntity<List<DiaLetivoDto>> buscaTudoPorIdTurma(@PathVariable Long idTurma) {
        return ResponseEntity.ok(service.buscaTudoPorTurmaId(idTurma));
    }

    @RequestMapping(path = "/{id}")
    public ResponseEntity<DiaLetivoDto> buscaPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.buscaPorId(id));
    }

    @PostMapping(path = "/filtros/turmas")
    public ResponseEntity<List<DiaLetivoDto>> buscaTudoPorTurma(@RequestBody TurmaDto turmaDto) {
        return ResponseEntity.ok(service.buscaTudoPorTurma(turmaDto));
    }

    @PostMapping
    public ResponseEntity<DiaLetivoDto> insere(@RequestBody DiaLetivoDto dto) {
        return ResponseEntity.ok(service.salvar(dto));
    }

    @PutMapping
    public ResponseEntity<DiaLetivoDto> atualiza(@RequestBody DiaLetivoDto dto) {
        return ResponseEntity.ok(service.salvar(dto));
    }

    @DeleteMapping
    public ResponseEntity<?> remove(@PathParam("id") Long id) {
        service.remove(id);
        return ResponseEntity.ok(true);
    }

}
