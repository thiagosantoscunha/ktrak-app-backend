package com.ktrakapp.domain.services;

import com.ktrakapp.domain.dto.DisciplinaDto;
import com.ktrakapp.domain.entities.DisciplinaEntity;
import com.ktrakapp.domain.entities.converters.DisciplinaConverter;
import com.ktrakapp.domain.repositories.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService implements Serializable {

    @Autowired
    private DisciplinaRepository repository;

    @Autowired
    private DisciplinaConverter converter;


    public List<DisciplinaDto> buscaTudo() {
        List<DisciplinaEntity> entities = repository.findAll();
        return converter.toDtoList(entities);
    }

    public DisciplinaDto insere(DisciplinaDto dto) {
        DisciplinaEntity entity = repository.save(converter.toEntity(dto));
        return converter.toDto(entity);
    }

    public DisciplinaDto atualiza(DisciplinaDto dto) {
        DisciplinaEntity entity = repository.save(converter.toEntity(dto));
        return converter.toDto(entity);
    }

    public DisciplinaDto buscaPorId(Long id) {
        Optional<DisciplinaEntity> entity = repository.findById(id);
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
