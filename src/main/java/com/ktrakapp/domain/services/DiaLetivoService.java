package com.ktrakapp.domain.services;

import com.ktrakapp.domain.dto.DiaLetivoDto;
import com.ktrakapp.domain.dto.TurmaDto;
import com.ktrakapp.domain.entities.DiaLetivoEntity;
import com.ktrakapp.domain.entities.TurmaEntity;
import com.ktrakapp.domain.entities.converters.DiaLetivoConverter;
import com.ktrakapp.domain.entities.converters.TurmaConverter;
import com.ktrakapp.domain.exceptions.NotFoundException;
import com.ktrakapp.domain.repositories.DiaLetivoRepository;
import com.ktrakapp.domain.repositories.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiaLetivoService {

    @Autowired
    private DiaLetivoRepository repository;

    @Autowired
    private DiaLetivoConverter converter;

    @Autowired
    private TurmaConverter turmaConverter;

    @Autowired
    private TurmaRepository turmaRepository;

    public List<DiaLetivoDto> buscaTudo() {
        return converter.toDtoList(
                repository.findAll()
        );
    }

    public List<DiaLetivoDto> buscaTudoPorTurma(TurmaDto turmaDto) {
        List<DiaLetivoEntity> entities = repository.findAllByTurma(turmaConverter.toEntity(turmaDto));
        return converter.toDtoList(entities);
    }

    public List<DiaLetivoDto> buscaTudoPorTurmaId(Long idTurma) {
        Optional<TurmaEntity> turmaEntity = turmaRepository.findById(idTurma);
        return turmaEntity.map(
                entity -> converter.toDtoList(
                        repository.findAllByTurma(entity))
        ).orElse(null);
    }

    public DiaLetivoDto salvar(DiaLetivoDto dto) {
        DiaLetivoEntity entity = repository.save(converter.toEntity(dto));
        return converter.toDto(entity);
    }

    public void remove(Long id) {
        repository.deleteById(id);
    }

    public DiaLetivoDto buscaPorId(Long id) {
        Optional<DiaLetivoEntity> entity = repository.findById(id);
        return entity.map(diaLetivoEntity -> converter.toDto(
                diaLetivoEntity
        )).orElseThrow(new NotFoundException("Não encontramos por Id").get());
    }



}
