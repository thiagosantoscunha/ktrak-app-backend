package br.com.ktrak.secretaria.api;

import br.com.ktrak.domain.dto.MatriculaDto;
import br.com.ktrak.domain.services.MatriculaFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "v1/matriculas/filter")
public class MatriculaFilterApi {

    @Autowired
    private MatriculaFilterService service;

    @GetMapping
    public ResponseEntity<List<MatriculaDto>> buscaTudoPorNomeCurso(@RequestParam String nomeCurso) {
        return ResponseEntity.ok(service.buscaTudoPorNomeCurso(nomeCurso));
    }

}
