package br.com.ktrak.secretaria.api;

import br.com.ktrak.secretaria.validators.QRCodeValidation;
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

    @Autowired
    private QRCodeValidation validation;

    @GetMapping()
    public ResponseEntity<List<QRCodeDto>> buscaTudo() {
        return ResponseEntity.ok(service.buscaTudo());
    }

    @GetMapping(path = "/current")
    public ResponseEntity<QRCodeDto> buscaPorDataRecente() {
        return ResponseEntity.ok(service.buscaPorDataRecente());
    }

    @GetMapping(path = "/generate")
    public ResponseEntity<QRCodeDto> generate() {
        validation.isNaoPodeGerar();
        return ResponseEntity.ok(service.generate());
    }

}
