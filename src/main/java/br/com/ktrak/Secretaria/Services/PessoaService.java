package br.com.ktrak.Secretaria.Services;

import br.com.ktrak.Secretaria.DTOs.ListaPessoaDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PessoaService {

    public List<ListaPessoaDTO> buscaTudo() {
        return new ArrayList<>();
    }

    public ListaPessoaDTO buscaPorId(Long id) {
        return new ListaPessoaDTO();
    }

}
