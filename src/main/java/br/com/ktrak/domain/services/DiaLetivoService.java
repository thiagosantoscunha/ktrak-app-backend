package br.com.ktrak.domain.services;

import br.com.ktrak.domain.converters.DiaLetivoConverter;
import br.com.ktrak.domain.converters.TurmaConverter;
import br.com.ktrak.domain.dto.DiaLetivoDto;
import br.com.ktrak.domain.dto.TurmaDto;
import br.com.ktrak.domain.exceptions.BadRequestException;
import br.com.ktrak.domain.exceptions.NotFoundException;
import br.com.ktrak.domain.repositories.DiaLetivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiaLetivoService {

    @Autowired
    private DiaLetivoRepository repository;

    @Autowired
    private DiaLetivoConverter converter;

    @Autowired
    private TurmaConverter turmaConverter;

    public List<DiaLetivoDto> buscaTudo() {
        return converter.toDtoList(
                repository.findAll()
        );
    }

    public List<DiaLetivoDto> buscaTudoPorTurma(TurmaDto turmaDto) {
        var entities = repository.findAllByTurma(turmaConverter.toEntity(turmaDto));
        return converter.toDtoList(entities);
    }

    public DiaLetivoDto salvar(DiaLetivoDto dto) {
        var entity = repository.save(converter.toEntity(dto));
        return converter.toDto(entity);
    }

    public void remove(Long id) {
        repository.deleteById(id);
    }

    public DiaLetivoDto buscaPorId(Long id) {
        var entity = repository.findById(id);
        return entity.map(diaLetivoEntity -> converter.toDto(
                diaLetivoEntity
        )).orElseThrow(new NotFoundException("Não encontramos por Id").get());
    }
}
