package com.ktrakapp.domain.services;

import com.ktrakapp.Utils.LocalFormatter;
import com.ktrakapp.domain.dto.SemestreDto;
import com.ktrakapp.domain.entities.converters.SemestreConverter;
import com.ktrakapp.domain.repositories.SemestreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SemestreService {

    @Autowired
    private SemestreRepository repository;

    @Autowired
    private SemestreConverter converter;

    public List<SemestreDto> buscaTudo() {
        return converter.toDtoList(repository.findAll());
    }

    public SemestreDto buscaPorId(Long id) {
        return repository.findById(id)
                .map(semestreEntity -> converter.toDto(semestreEntity))
                .orElse(null);
    }

    public SemestreDto salva(SemestreDto dto) {
        return converter.toDto(
                repository.save(
                        converter.toEntity(dto)
                )
        );
    }

    public void remove(Long id) {
        repository.deleteById(id);
    }

    public boolean existePorDataInicioAndFim(String dataInicio, String dataFim) {
        return repository.existsByDataInicioAndDataFim(
                LocalFormatter.toLocalDate(dataInicio),
                LocalFormatter.toLocalDate(dataFim)
        );
    }
}
