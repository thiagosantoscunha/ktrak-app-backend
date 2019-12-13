package com.ktrakapp.domain.services;

import com.ktrakapp.domain.dto.MatriculaDto;
import com.ktrakapp.domain.entities.MatriculaEntity;
import com.ktrakapp.domain.entities.converters.MatriculaConverter;
import com.ktrakapp.domain.repositories.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaFilterService {

    @Autowired
    private MatriculaRepository repository;

    @Autowired
    private MatriculaConverter converter;

    public List<MatriculaDto> buscaTudoPorNomeCurso(String nomeCurso) {
        List<MatriculaEntity> result = repository.findAllByNomeCurso(nomeCurso);
        return converter.toDtoList(result);
    }

}
