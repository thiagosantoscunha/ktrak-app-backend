package br.com.ktrak.mobile.api;

import br.com.ktrak.domain.dto.MarcaPresencaDto;
import br.com.ktrak.mobile.validators.MarcaPresencaValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "v1/qrcode")
public class MarcaPresencaApi {

    @Autowired
    private MarcaPresencaValidation marcaPresencaValidation;


    @PostMapping("/marca-presenca")
    public ResponseEntity<?> marcaPresencaDoAluno(@RequestBody MarcaPresencaDto dto) {
        marcaPresencaValidation.isNaoPodeMarcarPresenca(dto);
        return null;
    }

}
