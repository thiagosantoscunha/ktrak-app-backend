package br.com.ktrak.domain.services;

import br.com.ktrak.domain.converters.TurmaConverter;
import br.com.ktrak.domain.dto.TurmaDto;
import br.com.ktrak.domain.dto.in.AtualizaTurmaDto;
import br.com.ktrak.domain.dto.in.InsereTurmaDto;
import br.com.ktrak.domain.dto.out.ExibeTurmaDto;
import br.com.ktrak.domain.dto.out.TurmaOutDto;
import br.com.ktrak.domain.entities.TurmaEntity;
import br.com.ktrak.domain.repositories.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository repository;

    @Autowired
    private TurmaConverter converter;

    public List<TurmaDto> buscaTudo() {
        var entities = repository.findAll();
        return converter.toDtoList(entities);
    }

    public TurmaDto insere(TurmaDto dto) {
        var entity = repository.save(converter.toEntity(dto));
        return converter.toDto(entity);
    }

    public TurmaDto atualiza(TurmaDto dto) {
        var entity = converter.toEntity(dto);
        return converter.toDto(repository.save(entity));
    }

    public void remove(Long id) {
        repository.deleteById(id);
    }
}
