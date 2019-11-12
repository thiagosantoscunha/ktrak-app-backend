package br.com.ktrak.domain.services;

import br.com.ktrak.domain.dto.in.AtualizaDisciplinaDto;
import br.com.ktrak.domain.dto.out.ExibeDisciplinaDto;
import br.com.ktrak.domain.dto.in.InsereDisciplinaDto;
import br.com.ktrak.domain.repositories.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Service
public class DisciplinaService implements Serializable {

    @Autowired
    private DisciplinaRepository repository;

    public List<ExibeDisciplinaDto> buscaTudo() {
        var entities = repository.findAll();
        List<ExibeDisciplinaDto> disciplinas = new ArrayList<>();
        entities.forEach(d -> {
            ExibeDisciplinaDto dto = new ExibeDisciplinaDto();
            dto.toDto(d);
            disciplinas.add(dto);
        });
        return disciplinas;
    }

    public ExibeDisciplinaDto insere(InsereDisciplinaDto model) {
        var entity = model.toEntity();
        entity = repository.save(entity);
        var disciplinaInserida = new ExibeDisciplinaDto();
        disciplinaInserida.toDto(entity);
        return disciplinaInserida;
    }

    public boolean existePorNome(String nome) {
        return repository.existsByNome(nome);
    }

    public ExibeDisciplinaDto atualiza(AtualizaDisciplinaDto model) {
        var entity = model.toEntity();
        entity = repository.save(entity);
        var disciplinaAtualizada = new ExibeDisciplinaDto();
        disciplinaAtualizada.toDto(entity);
        return disciplinaAtualizada;
    }

    public boolean existePorId(Long id) {
        return repository.existsById(id);
    }

    public ExibeDisciplinaDto buscaPorId(Long id) {
        var entity = repository.findById(id);
        ExibeDisciplinaDto dto = new ExibeDisciplinaDto();
        entity.ifPresent(dto::toDto);
        return dto;
    }

    public void removePorId(Long id) {
        repository.deleteById(id);
    }
}
