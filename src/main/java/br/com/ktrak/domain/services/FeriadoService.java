package br.com.ktrak.domain.services;

import br.com.ktrak.Utils.LocalFormatter;
import br.com.ktrak.domain.converters.FeriadoConverter;
import br.com.ktrak.domain.dto.FeriadoDto;
import br.com.ktrak.domain.entities.FeriadoEntity;
import br.com.ktrak.domain.repositories.FeriadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeriadoService {

    @Autowired
    private FeriadoRepository repository;

    @Autowired
    private FeriadoConverter converter;


    public List<FeriadoDto> buscaTudo() {
        return converter.toDtoList(repository.findAll());
    }

    public FeriadoDto buscaPorId(Long id) {
        Optional<FeriadoEntity> entity = repository.findById(id);
        return entity.map(feriadoEntity -> converter.toDto(feriadoEntity)).orElse(null);
    }

    public FeriadoDto salva(FeriadoDto dto) {
        return converter.toDto(repository.save(converter.toEntity(dto)));
    }

    public void remove(Long id) {
        repository.deleteById(id);
    }


    public boolean existePorData(String data) {
        return repository.existsByData(LocalFormatter.toLocalDate(data));
    }
}
