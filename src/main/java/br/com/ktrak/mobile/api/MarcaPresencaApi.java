package br.com.ktrak.mobile.api;

import br.com.ktrak.domain.dto.MarcaPresencaDto;
import br.com.ktrak.domain.services.MarcaPresencaService;
import br.com.ktrak.mobile.validators.MarcaPresencaValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "mobile/v1/marca-presenca")
public class MarcaPresencaApi {

    @Autowired
    private MarcaPresencaValidation marcaPresencaValidation;
    @Autowired
    private MarcaPresencaService marcaPresencaService;

    @RequestMapping
    public ResponseEntity<?> marcaPresencaDoAluno(@RequestParam("username") String username, @RequestParam("key") String key) {
        MarcaPresencaDto dto = new MarcaPresencaDto(username, key);
        marcaPresencaValidation.isNaoPodeMarcarPresenca(dto);
        System.out.println(dto);
        return ResponseEntity.ok(dto);
    }
    @PostMapping
    @Transactional
    public ResponseEntity<?> insere(@RequestParam("username") String username, @RequestParam("key") String key) {
        MarcaPresencaDto dto = new MarcaPresencaDto(username, key);
        marcaPresencaValidation.isNaoPodeMarcarPresenca(dto);
        return new ResponseEntity<>(marcaPresencaService.marca(dto), HttpStatus.OK);
    }

}
