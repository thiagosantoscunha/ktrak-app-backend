package br.com.ktrak.domain.services;

import br.com.ktrak.secretaria.dto.AtualizaPessoaDto;
import br.com.ktrak.secretaria.dto.CriaPessoaDTO;
import br.com.ktrak.secretaria.dto.ListaPessoaDTO;
import br.com.ktrak.domain.repositories.PessoaRepository;
import br.com.ktrak.domain.entities.PessoaEntity;
import br.com.ktrak.secretaria.dto.RemovePessoaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Service
public class PessoaService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private PessoaRepository pessoaRepository;


    public List<ListaPessoaDTO> buscaTudo() {
        var pessoas = this.pessoaRepository.findAll();
        List<ListaPessoaDTO> pessoasResponseList = new ArrayList<>();
        if (pessoas != null) {
            pessoas.forEach(pessoa -> pessoasResponseList.add(ListaPessoaDTO.toDto(pessoa)));
        }
        return pessoasResponseList;
    }

    public ListaPessoaDTO buscaPorId(Long id) {
        var response = pessoaRepository.findById(id);
        return response.isEmpty() ? null : ListaPessoaDTO.toDto(response.get());
    }

    public ListaPessoaDTO insere(CriaPessoaDTO pessoa) {
        PessoaEntity entity = pessoa.toEntity();
        entity = pessoaRepository.save(entity);
        return ListaPessoaDTO.toDto(entity);
    }

	public ListaPessoaDTO atualiza(AtualizaPessoaDto pessoaDto) {
        PessoaEntity entity = pessoaDto.toEntity();
        entity = pessoaRepository.save(entity);
        return ListaPessoaDTO.toDto(entity);
	}

    public Boolean remove(RemovePessoaDTO pessoa) {
        pessoaRepository.delete(pessoa.toEntity());
        return !pessoaRepository.existsById(pessoa.id);
    }
}
