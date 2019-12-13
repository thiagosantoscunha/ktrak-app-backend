package com.ktrakapp.domain.services;

import com.ktrakapp.Utils.LocalFormatter;
import com.ktrakapp.domain.dto.RecessoDto;
import com.ktrakapp.domain.entities.RecessoEntity;
import com.ktrakapp.domain.entities.converters.RecessoConverter;
import com.ktrakapp.domain.repositories.RecessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecessoService {

    @Autowired
    private RecessoRepository repository;

    @Autowired
    private RecessoConverter converter;


    public List<RecessoDto> buscaTudo() {
        return converter.toDtoList(repository.findAll());
    }

    public RecessoDto buscaPorId(Long id) {
        Optional<RecessoEntity> entity = repository.findById(id);
        return entity.map(feriadoEntity -> converter.toDto(feriadoEntity)).orElse(null);
    }

    public RecessoDto salva(RecessoDto dto) {
        return converter.toDto(repository.save(converter.toEntity(dto)));
    }

    public void remove(Long id) {
        repository.deleteById(id);
    }


    public boolean existePorData(String data) {
        return repository.existsByData(LocalFormatter.toLocalDate(data));
    }
}
