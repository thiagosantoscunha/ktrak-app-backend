package br.com.ktrak.secretaria.api;

import br.com.ktrak.domain.dto.MatriculaDto;
import br.com.ktrak.domain.services.MatriculaService;
import br.com.ktrak.secretaria.validators.MatriculaValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
        var response = matriculaService.buscaTudo();
        HttpHeaders headers = new HttpHeaders();
        headers.add("size", response.size() + "");
        return ResponseEntity.ok().headers(headers).body(response);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<MatriculaDto> insere(@RequestBody MatriculaDto dto) {
        matriculaValidation.isNaoPodeInserir(dto);
        var response = matriculaService.salva(dto);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<MatriculaDto> update(@RequestBody MatriculaDto dto) {
        matriculaValidation.isNaoPodeAtualizar(dto);
        var response = matriculaService.salva(dto);
        return ResponseEntity.ok(response);
    }

}
