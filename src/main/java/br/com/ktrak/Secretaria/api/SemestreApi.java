package br.com.ktrak.secretaria.api;


import br.com.ktrak.domain.dto.SemestreDto;
import br.com.ktrak.domain.services.SemestreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "v1/semestres")
public class SemestreApi {

    @Autowired
    private SemestreService service;

    @GetMapping
    public ResponseEntity<List<SemestreDto>> buscaTudo() {
        return ResponseEntity.ok(service.buscaTudo());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<SemestreDto> buscaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscaPorId(id));
    }

    @PostMapping
    public ResponseEntity<SemestreDto> insere(@RequestBody SemestreDto dto) {
        return ResponseEntity.ok(service.salva(dto));
    }

    @PutMapping
    public ResponseEntity<SemestreDto> atualiza(@RequestBody SemestreDto dto) {
        return ResponseEntity.ok(service.salva(dto));
    }

    @DeleteMapping
    public ResponseEntity<?> remove(@RequestParam("id") Long id) {
        service.remove(id);
        return ResponseEntity.ok(true);
    }

}
