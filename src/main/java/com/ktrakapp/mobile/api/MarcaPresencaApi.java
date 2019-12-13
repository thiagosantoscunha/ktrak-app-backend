package com.ktrakapp.mobile.api;

import com.ktrakapp.domain.dto.MarcaPresencaDto;
import com.ktrakapp.domain.services.MarcaPresencaService;
import com.ktrakapp.mobile.validators.MarcaPresencaValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "mobile/v1/marca-presenca")
public class MarcaPresencaApi {

    @Autowired
    private MarcaPresencaValidation marcaPresencaValidation;
    @Autowired
    private MarcaPresencaService marcaPresencaService;

    @RequestMapping
    @Transactional
    public ResponseEntity<?> insere(@RequestParam("username") String username, @RequestParam("key") String key) {
        MarcaPresencaDto dto = new MarcaPresencaDto(username, key);
        marcaPresencaValidation.isNaoPodeMarcarPresenca(dto);
        return ResponseEntity.ok(marcaPresencaService.insere(dto));
    }

}
