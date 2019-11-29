package br.com.ktrak.mobile.api;

import br.com.ktrak.domain.dto.MarcaPresencaDto;
import br.com.ktrak.mobile.validators.MarcaPresencaValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "mobile/v1/marca-presenca")
public class MarcaPresencaApi {

    @Autowired
    private MarcaPresencaValidation marcaPresencaValidation;

    @RequestMapping
    public ResponseEntity<?> marcaPresencaDoAluno(@RequestParam("username") String username, @RequestParam("key") String key) {
        MarcaPresencaDto dto = new MarcaPresencaDto(username, key);
        marcaPresencaValidation.isNaoPodeMarcarPresenca(dto);
        System.out.println(dto);
        return ResponseEntity.ok(dto);
    }

}
