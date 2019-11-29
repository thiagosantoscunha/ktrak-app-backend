package br.com.ktrak.mobile.api;

import br.com.ktrak.domain.dto.AlunoDto;
import br.com.ktrak.domain.dto.TurmaDto;
import br.com.ktrak.domain.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

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
