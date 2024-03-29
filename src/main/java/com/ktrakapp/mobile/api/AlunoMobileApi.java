package com.ktrakapp.mobile.api;

import com.ktrakapp.domain.dto.AlunoDto;
import com.ktrakapp.domain.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping(path = "mobile/v1/alunos")
public class AlunoMobileApi {

    @Autowired
    private AlunoService service;

    @GetMapping
    public ResponseEntity<AlunoDto> buscaPoUsername(@PathParam("username") String username) {
        return ResponseEntity.ok(service.buscaPorUsername(username));
    }

}
