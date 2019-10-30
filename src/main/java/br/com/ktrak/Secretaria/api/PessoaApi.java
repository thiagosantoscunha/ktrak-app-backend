package br.com.ktrak.secretaria.api;

import br.com.ktrak.Utils.BodyResponse;
import br.com.ktrak.Utils.ResponseRest;
import br.com.ktrak.secretaria.dto.AtualizaPessoaDto;
import br.com.ktrak.secretaria.dto.CriaPessoaDTO;
import br.com.ktrak.secretaria.dto.ListaPessoaDTO;
import br.com.ktrak.domain.services.PessoaService;
import br.com.ktrak.secretaria.dto.RemovePessoaDTO;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping(value = "v1/pessoas", produces = "application/json")
public class PessoaApi {

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private BodyResponse bodyResponse;


    @GetMapping
    public ResponseEntity<List<ListaPessoaDTO>> buscaTudo() {
        var pessoas = pessoaService.buscaTudo();
        return new ResponseEntity<>(pessoas, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ListaPessoaDTO> buscaPorId(@PathVariable("id") Long id) {
        ListaPessoaDTO pessoa = pessoaService.buscaPorId(id);
        if (pessoa == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        pessoa.id = id;
        return new ResponseEntity<>(pessoa, HttpStatus.OK);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ListaPessoaDTO> insere(@RequestBody CriaPessoaDTO pessoa) {
        var response = pessoaService.insere(pessoa);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody RemovePessoaDTO pessoa) {
        var result = pessoaService.remove(pessoa);
        bodyResponse.message = "Deletado com sucesso";
        bodyResponse.data = pessoa;
        return new ResponseEntity<>(bodyResponse, HttpStatus.OK);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<?> atualiza(@RequestBody AtualizaPessoaDto pessoaDto) {
        var response = pessoaService.atualiza(pessoaDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
