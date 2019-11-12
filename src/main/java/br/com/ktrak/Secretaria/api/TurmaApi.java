package br.com.ktrak.secretaria.api;


import br.com.ktrak.domain.dto.in.AtualizaTurmaDto;
import br.com.ktrak.domain.dto.in.InsereTurmaDto;
import br.com.ktrak.domain.dto.out.ExibeTurmaDto;
import br.com.ktrak.domain.services.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(path = "v1/turmas")
public class TurmaApi {

    @Autowired
    private TurmaService service;

    @GetMapping
    public ResponseEntity<List<ExibeTurmaDto>> buscaTudo() {
        var turmas = service.buscaTudo();
        return new ResponseEntity<>(turmas, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ExibeTurmaDto> insere(@RequestBody InsereTurmaDto dto) {
        var entityInserido = service.insere(dto);
        return new ResponseEntity<>(entityInserido, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ExibeTurmaDto> atualiza(@RequestBody AtualizaTurmaDto dto) {
        var turmaAtualizada = service.atualiza(dto);
        return new ResponseEntity<>(turmaAtualizada, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> remove(@PathParam("id") Long id) {
        service.remove(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

}

