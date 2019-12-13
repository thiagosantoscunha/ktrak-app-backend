package com.ktrakapp.secretaria.api;

import com.ktrakapp.domain.dto.MatriculaDto;
import com.ktrakapp.domain.services.MatriculaService;
import com.ktrakapp.secretaria.validators.MatriculaValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping(path = "v1/matriculas")
public class MatriculaApi {

    @Autowired
    private MatriculaService matriculaService;

    @Autowired
    private MatriculaValidation matriculaValidation;

    @GetMapping
    public ResponseEntity<List<MatriculaDto>> buscaTudo() {
        return ResponseEntity.ok(matriculaService.buscaTudo());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<MatriculaDto> buscaPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(matriculaService.buscaPorId(id));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<MatriculaDto> insere(@RequestBody MatriculaDto dto) {
        matriculaValidation.isNaoPodeInserir(dto);
        return ResponseEntity.ok(matriculaService.salva(dto));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<MatriculaDto> update(@RequestBody MatriculaDto dto) {
        matriculaValidation.isNaoPodeAtualizar(dto);
        return ResponseEntity.ok(matriculaService.salva(dto));
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam Long id) {
        matriculaService.remove(id);
        return ResponseEntity.ok(true);
    }

}
