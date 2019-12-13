package com.ktrakapp.mobile.api;

import com.ktrakapp.domain.dto.TurmaDto;
import com.ktrakapp.domain.services.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(path = "mobile/v1/turmas")
public class TurmaMobileApi {

    @Autowired
    private TurmaService service;

    @GetMapping
    public ResponseEntity<List<TurmaDto>> buscaTudo(@PathParam("alunoId") Long alunoId) {
        return ResponseEntity.ok(service.buscaTodasAsTurmasPorIdAluno(alunoId));
    }

}
