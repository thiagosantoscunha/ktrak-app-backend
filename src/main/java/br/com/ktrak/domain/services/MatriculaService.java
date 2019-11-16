package br.com.ktrak.domain.services;

import br.com.ktrak.Utils.LocalFormatter;
import br.com.ktrak.domain.converters.MatriculaConverter;
import br.com.ktrak.domain.dto.MatriculaAlunoNaTurmaDto;
import br.com.ktrak.domain.dto.MatriculaDto;
import br.com.ktrak.domain.entities.AlunoEntity;
import br.com.ktrak.domain.entities.MatriculaEntity;
import br.com.ktrak.domain.entities.TurmaEntity;
import br.com.ktrak.domain.repositories.AlunoRepository;
import br.com.ktrak.domain.repositories.MatriculaRepository;
import br.com.ktrak.domain.repositories.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
public class MatriculaService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private TurmaRepository turmaRepository;

    @Autowired
    private MatriculaConverter matriculaConverter;

    public List<MatriculaDto> buscaTudo() {
        var entities = matriculaRepository.findAll();
        return matriculaConverter.toDtoList(entities);
    }

    public MatriculaDto buscaMatriculaPorId(Long id) {
        var entity = matriculaRepository.findById(id);
        return entity.map(matriculaEntity -> matriculaConverter.toDto(matriculaEntity)).orElse(null);
    }

    public MatriculaDto salva(MatriculaDto dto) {

        Optional<AlunoEntity> aluno = alunoRepository.findById(dto.getAluno().getId());
        Optional<TurmaEntity> turma = turmaRepository.findById(dto.getTurma().getId());

        MatriculaEntity matriculaEntity = new MatriculaEntity();
        matriculaEntity.setNumero(MatriculaGeneratorService.build());
        aluno.ifPresent(matriculaEntity::setAluno);
        turma.ifPresent(matriculaEntity::setTurma);

        var entity = matriculaRepository.save(matriculaEntity);

        return matriculaConverter.toDto(entity);
    }
}
