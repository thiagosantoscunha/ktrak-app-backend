package br.com.ktrak.domain.services;

import br.com.ktrak.domain.converters.ProfessorConverter;
import br.com.ktrak.domain.dto.ProfessorDto;
import br.com.ktrak.domain.repositories.ProfessorRepository;
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
        var entities = repository.findAll();
        return converter.toDtoList(entities);
    }

    public ProfessorDto insere(ProfessorDto dto) {
        var entity = repository.save(converter.toEntity(dto));
        return converter.toDto(entity);
    }

    public boolean existePorId(Long id) {
        return repository.existsById(id);
    }

    public ProfessorDto buscaPorId(Long id) {
        return repository.findById(id).map(professorEntity -> converter.toDto(professorEntity)).orElse(null);
    }

    public ProfessorDto atualiza(ProfessorDto dto) {
        var entity = repository.save(converter.toEntity(dto));
        return converter.toDto(entity);
    }

    public void remove(Long id) {
        repository.deleteById(id);
    }
}
