package com.ktrakapp.domain.services;

import com.ktrakapp.domain.dto.AlunoDto;
import com.ktrakapp.domain.dto.MatriculaDto;
import com.ktrakapp.domain.dto.TurmaDto;
import com.ktrakapp.domain.entities.MatriculaEntity;
import com.ktrakapp.domain.entities.converters.AlunoConverter;
import com.ktrakapp.domain.entities.converters.MatriculaConverter;
import com.ktrakapp.domain.entities.converters.TurmaConverter;
import com.ktrakapp.domain.repositories.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Service
public class MatriculaService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired
    private MatriculaConverter matriculaConverter;

    @Autowired
    private AlunoConverter alunoConverter;

    @Autowired
    private TurmaConverter turmaConverter;

    public List<MatriculaDto> buscaTudo() {
        return matriculaConverter.toDtoList(matriculaRepository.findAll());
    }

    public MatriculaDto buscaPorId(Long id) {
        return matriculaRepository.findById(id).map(matriculaEntity -> matriculaConverter.toDto(matriculaEntity)).orElse(null);
    }

    public MatriculaDto salva(MatriculaDto dto) {
        MatriculaEntity matriculaEntity = new MatriculaEntity();
        matriculaEntity.setNumero(MatriculaGeneratorService.build());
        matriculaEntity.setAluno(alunoConverter.toEntity(dto.getAluno()));
        matriculaEntity.setTurma(turmaConverter.toEntity(dto.getTurma()));
        return matriculaConverter.toDto(matriculaRepository.save(matriculaEntity));
    }

    public void remove(Long id) {
        matriculaRepository.deleteById(id);
    }

    public boolean existePorAlunoAndTurma(AlunoDto alunoDto, TurmaDto turmaDto) {
        return matriculaRepository.existsByAlunoAndTurma(alunoConverter.toEntity(alunoDto), turmaConverter.toEntity(turmaDto));
    }

    public List<MatriculaDto> buscaTudoPorAluno(AlunoDto alunoDto) {
        return matriculaRepository
                .findAllByAluno(alunoConverter.toEntity(alunoDto))
                .map(matriculaEntities -> matriculaConverter.toDtoList(matriculaEntities))
                .orElseGet(ArrayList::new);
    }

    public MatriculaDto buscaPorTurma(TurmaDto t) {
        return matriculaConverter.toDto(matriculaRepository.findByTurma(turmaConverter.toEntity(t)));
    }

    public MatriculaDto buscaPorTurmaEAluno(TurmaDto turmaDto, AlunoDto alunoDto) {
        return matriculaConverter.toDto(matriculaRepository.findByTurmaAndAluno(turmaConverter.toEntity(turmaDto), alunoConverter.toEntity(alunoDto)));
    }
}
