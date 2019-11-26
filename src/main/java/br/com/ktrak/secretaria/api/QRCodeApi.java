package br.com.ktrak.secretaria.api;

import br.com.ktrak.domain.converters.QRCodeConverter;
import br.com.ktrak.security.Entities.QRCodeEntity;
import br.com.ktrak.security.dto.QRCodeDto;
import br.com.ktrak.security.services.QRCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "v1/qrcode")
public class QRCodeApi {

    @Autowired
    private QRCodeService service;

    @GetMapping()
    public ResponseEntity<List<QRCodeDto>> buscaTudo() {
        return ResponseEntity.ok(service.buscaTudo());
    }

    @GetMapping(path = "/current")
    public ResponseEntity<QRCodeDto> buscaPorDataMaisRecente() {
        return ResponseEntity.ok(service.buscaPorDataMaisRecente());
    }

    @PostMapping
    public ResponseEntity<QRCodeDto> generate() {
        return ResponseEntity.ok(service.generate());
    }

}
