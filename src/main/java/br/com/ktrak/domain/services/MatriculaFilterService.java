package br.com.ktrak.domain.services;

import br.com.ktrak.domain.converters.MatriculaConverter;
import br.com.ktrak.domain.dto.MatriculaDto;
import br.com.ktrak.domain.repositories.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class MatriculaFilterService {

    @Autowired
    private MatriculaRepository repository;

    @Autowired
    private MatriculaConverter converter;

    public List<MatriculaDto> buscaTudoPorNomeCurso(String nomeCurso) {
        var result = repository.findAllByNomeCurso(nomeCurso);
        return converter.toDtoList(result);
    }

}
