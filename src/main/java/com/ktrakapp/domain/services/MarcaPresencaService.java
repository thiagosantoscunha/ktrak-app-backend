package com.ktrakapp.domain.services;


import com.ktrakapp.domain.dto.*;
import com.ktrakapp.domain.entities.DiaLetivoEntity;
import com.ktrakapp.domain.entities.PresenciamentoEntity;
import com.ktrakapp.domain.entities.converters.DiaLetivoConverter;
import com.ktrakapp.domain.entities.converters.MatriculaConverter;
import com.ktrakapp.domain.entities.converters.PresenciamentoConverter;
import com.ktrakapp.domain.entities.converters.TurmaConverter;
import com.ktrakapp.domain.repositories.DiaLetivoRepository;
import com.ktrakapp.domain.repositories.PresenciamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Service
public class MarcaPresencaService implements Serializable {

    @Autowired
    private PresenciamentoRepository repository;

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private TurmaService turmaService;

    @Autowired
    private DiaLetivoService diaLetivoService;

    @Autowired
    private DiaLetivoRepository diaLetivoRepository;

    @Autowired
    private MatriculaService matriculaService;

    @Autowired
    private DiaLetivoConverter diaLetivoConverter;

    @Autowired
    private MatriculaConverter matriculaConverter;

    @Autowired
    private PresenciamentoConverter presenciamentoConverter;

    @Autowired
    private TurmaConverter turmaConverter;

    public PresenciamentoDto insere(MarcaPresencaDto dto) {

        LocalDate dataDeHoje = LocalDate.now();
        AlunoDto alunoDto = alunoService.buscaPorUsername(dto.getUsername());
        List<MatriculaDto> matriculas = matriculaService.buscaTudoPorAluno(alunoDto);

        List<TurmaDto> turmaResponseList = turmaService.buscaTodasAsTurmasPorIdAluno(alunoDto.getId());

        PresenciamentoEntity entity = new PresenciamentoEntity();
        for (TurmaDto t: turmaResponseList) {

            List<DiaLetivoEntity> diaLetivoEntities = diaLetivoRepository.findAllByTurma(turmaConverter.toEntity(t));

            if (diaLetivoEntities != null || !diaLetivoEntities.isEmpty()) {

                for (DiaLetivoEntity dl: diaLetivoEntities) {
                    if (dl.getDataHora().toLocalDate().isEqual(dataDeHoje)) {
                        entity.setDiaLetivo(dl);
                        MatriculaDto matriculaDto = matriculaService.buscaPorTurmaEAluno(t, alunoDto);
                        entity.setMatricula(matriculaConverter.toEntity(matriculaDto));
                        entity.setIsPresente(true);
                        entity = repository.save(entity);
                        return presenciamentoConverter.toDto(entity);
                    }
                }

            }
        }
        return null;
    }
}

