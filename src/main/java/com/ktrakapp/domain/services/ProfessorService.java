package com.ktrakapp.domain.services;

import com.ktrakapp.domain.dto.ProfessorDto;
import com.ktrakapp.domain.entities.converters.ProfessorConverter;
import com.ktrakapp.domain.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class ProfessorService implements Serializable {

    @Autowired
    private ProfessorRepository repository;

    @Autowired
    private ProfessorConverter converter;

    public List<ProfessorDto> buscaTudo() {
        return converter.toDtoList(repository.findAllByOrderByNomeAsc());
    }

    public ProfessorDto insere(ProfessorDto dto) {
        return converter.toDto(repository.save(converter.toEntity(dto)));
    }

    public boolean existePorId(Long id) {
        return repository.existsById(id);
    }

    public ProfessorDto buscaPorId(Long id) {
        return repository.findById(id).map(professorEntity -> converter.toDto(professorEntity)).orElse(null);
    }

    public ProfessorDto atualiza(ProfessorDto dto) {
        return converter.toDto(repository.save(converter.toEntity(dto)));
    }

    public void remove(Long id) {
        repository.deleteById(id);
    }
}
