package com.ktrakapp.secretaria.api;

import com.ktrakapp.domain.dto.MatriculaDto;
import com.ktrakapp.domain.services.MatriculaFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
