package br.com.ktrak.domain.services;

import br.com.ktrak.domain.converters.DisciplinaConverter;
import br.com.ktrak.domain.dto.DisciplinaDto;
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

    @Autowired
    private DisciplinaConverter converter;


    public List<DisciplinaDto> buscaTudo() {
        var entities = repository.findAll();
        return converter.toDtoList(entities);
    }

    public DisciplinaDto insere(DisciplinaDto dto) {
        var entity = repository.save(converter.toEntity(dto));
        return converter.toDto(entity);
    }

    public DisciplinaDto atualiza(DisciplinaDto dto) {
        var entity = repository.save(converter.toEntity(dto));
        return converter.toDto(entity);
    }

    public DisciplinaDto buscaPorId(Long id) {
        var entity = repository.findById(id);
        return entity.map(e -> converter.toDto(e)).orElse(null);
    }

    public void removePorId(Long id) {
        repository.deleteById(id);
    }

    public boolean existePorNome(String nome) {
        return repository.existsByNome(nome);
    }

    public boolean existePorId(Long id) {
        return repository.existsById(id);
    }
}
