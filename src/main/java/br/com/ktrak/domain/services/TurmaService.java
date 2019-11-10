package br.com.ktrak.domain.services;

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
    TurmaRepository repository;

    public List<ExibeTurmaDto> buscaTudo() {
        var entities = repository.findAll();
        List<ExibeTurmaDto> turmas = new ArrayList<>();
        entities.forEach(e -> {
            ExibeTurmaDto dto = new ExibeTurmaDto();
            dto.toDto(e);
            turmas.add(dto);
        });
        return turmas;
    }

    public TurmaEntity insere(TurmaEntity entity) {
        return repository.save(entity);
    }
}
