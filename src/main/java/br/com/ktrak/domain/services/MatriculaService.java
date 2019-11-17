package br.com.ktrak.domain.services;

import br.com.ktrak.domain.converters.AlunoConverter;
import br.com.ktrak.domain.converters.MatriculaConverter;
import br.com.ktrak.domain.converters.ProfessorConverter;
import br.com.ktrak.domain.converters.TurmaConverter;
import br.com.ktrak.domain.dto.AlunoDto;
import br.com.ktrak.domain.dto.MatriculaDto;
import br.com.ktrak.domain.dto.TurmaDto;
import br.com.ktrak.domain.entities.MatriculaEntity;
import br.com.ktrak.domain.repositories.MatriculaRepository;
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
        var entities = matriculaRepository.findAll();
        return matriculaConverter.toDtoList(entities);
    }

    public MatriculaDto buscaPorId(Long id) {
        var entity = matriculaRepository.findById(id);
        return entity.map(matriculaEntity -> matriculaConverter.toDto(matriculaEntity)).orElse(null);
    }

    public MatriculaDto salva(MatriculaDto dto) {
        var matriculaEntity = new MatriculaEntity();
        matriculaEntity.setNumero(MatriculaGeneratorService.build());
        matriculaEntity.setAluno(alunoConverter.toEntity(dto.getAluno()));
        matriculaEntity.setTurma(turmaConverter.toEntity(dto.getTurma()));
        var entity = matriculaRepository.save(matriculaEntity);
        return matriculaConverter.toDto(entity);
    }

    public void remove(Long id) {
        matriculaRepository.deleteById(id);
    }

    public boolean existePorAlunoAndTurma(AlunoDto alunoDto, TurmaDto turmaDto) {
        return matriculaRepository.existsByAlunoAndTurma(alunoConverter.toEntity(alunoDto), turmaConverter.toEntity(turmaDto));
    }

    public List<MatriculaDto> buscaTudoPorAluno(AlunoDto alunoDto) {
        var matriculas = matriculaRepository.findAllByAluno(alunoConverter.toEntity(alunoDto));
        return matriculas.map(
                matriculaEntities -> matriculaConverter.toDtoList(matriculaEntities)
        ).orElseGet(ArrayList::new);
    }
}
