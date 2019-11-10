package br.com.ktrak.domain.services;

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

    public ExibeTurmaDto insere(InsereTurmaDto dto) {
        var entity = dto.toEntity();
        ExibeTurmaDto dtoInserido = new ExibeTurmaDto();
        dtoInserido.toDto(repository.save(entity));
        return dtoInserido;
    }

    public ExibeTurmaDto atualiza(AtualizaTurmaDto dto) {
        var entity = dto.toEntity();
        ExibeTurmaDto dtoAtualizado = new ExibeTurmaDto();
        dtoAtualizado.toDto(entity);
        return dtoAtualizado;
    }

    public void remove(Long id) {
        repository.deleteById(id);
    }
}
