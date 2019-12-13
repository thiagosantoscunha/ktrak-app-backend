package com.ktrakapp.secretaria.api;

import com.ktrakapp.domain.dto.RecessoDto;
import com.ktrakapp.domain.services.RecessoService;
import com.ktrakapp.secretaria.validators.RecessoValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(path = "v1/recessos")
public class RecessoApi {

    @Autowired
    private RecessoService service;

    @Autowired
    private RecessoValidation validation;

    @GetMapping
    public ResponseEntity<List<RecessoDto>> buscaTudo() {
        return ResponseEntity.ok(service.buscaTudo());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<RecessoDto> buscaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscaPorId(id));
    }

    @PostMapping
    public ResponseEntity<RecessoDto> insere(@RequestBody RecessoDto dto) {
        validation.isNaoPodeInserir(dto);
        return ResponseEntity.ok(service.salva(dto));
    }

    @PutMapping
    public ResponseEntity<RecessoDto> atualiza(@RequestBody RecessoDto dto) {
        validation.isNaoPodeAtualizar(dto);
        return ResponseEntity.ok(service.salva(dto));
    }

    @DeleteMapping
    public ResponseEntity<?> remove(@PathParam("id") Long id) {
        service.remove(id);
        return ResponseEntity.ok(true);
    }


}
