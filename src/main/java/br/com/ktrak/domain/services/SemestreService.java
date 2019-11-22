package br.com.ktrak.domain.services;

import br.com.ktrak.Utils.LocalFormatter;
import br.com.ktrak.domain.converters.SemestreConverter;
import br.com.ktrak.domain.dto.SemestreDto;
import br.com.ktrak.domain.repositories.SemestreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
        var entity = repository.findById(id);
        return entity.map(semestreEntity -> converter.toDto(semestreEntity)).orElse(null);
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
