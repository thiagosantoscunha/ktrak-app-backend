package br.com.ktrak.Secretaria.APIs;

import br.com.ktrak.Secretaria.DTOs.CriaPessoaDTO;
import br.com.ktrak.Secretaria.DTOs.ListaPessoaDTO;
import br.com.ktrak.Secretaria.Services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("v1/pessoas")
public class PessoaApi {

    @Autowired
    private PessoaService pessoaService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ListaPessoaDTO>> buscaTudo() {
        try {
            var pessoas = pessoaService.buscaTudo();
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
        } catch ( e) {
            return new Exception(e.getMessage(), );
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<ListaPessoaDTO> buscaPorId(@PathVariable("id") Long id) {
        ListaPessoaDTO pessoa = pessoaService.buscaPorId(id);
        if (pessoa == null) {
            return new ResponseEntity<>(new CustomErrorType("Pessoa não encontrada"), HttpStatus.NOT_FOUND);
        }
        pessoa.id = id;
        return new ResponseEntity<>(pessoa, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public CriaPessoaDTO insere() {
        return null;
    }
}
