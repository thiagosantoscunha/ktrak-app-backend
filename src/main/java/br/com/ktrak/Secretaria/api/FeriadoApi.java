package br.com.ktrak.secretaria.api;

import br.com.ktrak.domain.dto.FeriadoDto;
import br.com.ktrak.domain.services.FeriadoService;
import br.com.ktrak.secretaria.validators.FeriadoValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(path = "v1/feriados")
public class FeriadoApi {

    @Autowired
    private FeriadoService service;

    @Autowired
    private FeriadoValidation validation;

    @GetMapping
    public ResponseEntity<List<FeriadoDto>> buscaTudo() {
        return ResponseEntity.ok(service.buscaTudo());
    }

    @GetMapping
    public ResponseEntity<FeriadoDto> buscaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscaPorId(id));
    }

    @PostMapping
    public ResponseEntity<FeriadoDto> insere(@RequestBody FeriadoDto dto) {
        validation.isNaoPodeInserir(dto);
        return ResponseEntity.ok(service.salva(dto));
    }

    @PutMapping
    public ResponseEntity<FeriadoDto> atualiza(@RequestBody FeriadoDto dto) {
        validation.isNaoPodeAtualizar(dto);
        return ResponseEntity.ok(service.salva(dto));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> remove(@PathParam("id") Long id) {
        service.remove(id);
        return ResponseEntity.ok(true);
    }


}
