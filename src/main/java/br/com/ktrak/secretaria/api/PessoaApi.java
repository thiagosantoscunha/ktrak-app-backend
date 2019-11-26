package br.com.ktrak.secretaria.api;

import br.com.ktrak.domain.dto.PessoaDto;
import br.com.ktrak.domain.entities.PessoaEntity;
import br.com.ktrak.domain.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping(path = "v1/pessoas")
public class PessoaApi {

    @Autowired
    private PessoaService service;

    @RequestMapping
    public ResponseEntity<PessoaDto> buscaPorUsername(@PathParam("username") String username) {
        return ResponseEntity.ok(service.buscaPorUsername(username));
    }

}
