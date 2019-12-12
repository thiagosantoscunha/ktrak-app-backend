package br.com.ktrak.domain.services;


import br.com.ktrak.domain.dto.MarcaPresencaDto;
import br.com.ktrak.domain.entities.PresenciamentoEntity;
import br.com.ktrak.domain.repositories.PresenciamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarcaPresencaService {

    @Autowired
    private PresenciamentoRepository repository;

    public MarcaPresencaDto marca(MarcaPresencaDto dto) {

        PresenciamentoEntity entity = dto.toEntity();

        entity = repository.save(entity);
        return dto;
    }
}

