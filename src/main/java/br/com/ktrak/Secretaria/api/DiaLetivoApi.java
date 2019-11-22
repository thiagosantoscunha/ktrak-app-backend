package br.com.ktrak.secretaria.api;


import br.com.ktrak.domain.dto.DiaLetivoDto;
import br.com.ktrak.domain.dto.TurmaDto;
import br.com.ktrak.domain.services.DiaLetivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
        var responseList = service.buscaTudo();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("size", responseList.size() + "");
        return ResponseEntity.ok().headers(responseHeaders).body(responseList);
    }

    @RequestMapping(path = "/turmas/{idTurma}")
    public ResponseEntity<List<DiaLetivoDto>> buscaTudoPorIdTurma(@PathVariable Long idTurma) {
        var responseList = service.buscaTudoPorTurmaId(idTurma);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("size", responseList.size() + "");
        return ResponseEntity.ok().headers(responseHeaders).body(responseList);
    }

    @RequestMapping(path = "/{id}")
    public ResponseEntity<DiaLetivoDto> buscaPorId(@PathVariable("id") Long id) {
        var response = service.buscaPorId(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping(path = "/filtros/turmas")
    public ResponseEntity<List<DiaLetivoDto>> buscaTudoPorTurma(@RequestBody TurmaDto turmaDto) {
        var responseList = service.buscaTudoPorTurma(turmaDto);
        return ResponseEntity.ok(responseList);
    }

    @PostMapping
    public ResponseEntity<DiaLetivoDto> insere(@RequestBody DiaLetivoDto dto) {
        var response = service.salvar(dto);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<DiaLetivoDto> atualiza(@RequestBody DiaLetivoDto dto) {
        var response = service.salvar(dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping
    public ResponseEntity<?> remove(@PathParam("id") Long id) {
        service.remove(id);
        return ResponseEntity.ok(true);
    }

}
