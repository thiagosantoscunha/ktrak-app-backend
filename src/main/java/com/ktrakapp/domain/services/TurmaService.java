package com.ktrakapp.domain.services;

import com.ktrakapp.Utils.AimbraFluentValidationApi.DataValidationImpl;
import com.ktrakapp.Utils.LocalFormatter;
import com.ktrakapp.domain.dto.SemestreDto;
import com.ktrakapp.domain.dto.TurmaDto;
import com.ktrakapp.domain.entities.*;
import com.ktrakapp.domain.entities.converters.SemestreConverter;
import com.ktrakapp.domain.entities.converters.TurmaComMatriculaConverter;
import com.ktrakapp.domain.entities.converters.TurmaConverter;
import com.ktrakapp.domain.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TurmaService implements Serializable {

    @Autowired
    private TurmaRepository repository;

    @Autowired
    private DiaLetivoRepository diaLetivoRepository;

    @Autowired
    private SemestreRepository semestreRepository;

    @Autowired
    private TurmaConverter converter;

    @Autowired
    private SemestreConverter semestreConverter;

    @Autowired
    private DataValidationImpl dataValidation;

    @Autowired
    private RecessoRepository feriadoRepository;

    @Autowired
    private TurmaComMatriculaConverter turmaComMatriculaConverter;

    @Autowired
    private AlunoRepository alunoRepository;

    public List<TurmaDto> buscaTudo() {
        return turmaComMatriculaConverter.toDtoList(repository.findAll());
    }

    public TurmaDto insere(TurmaDto dto) {
        return converter.toDto(
                repository.save(converter.toEntity(dto))
        );
    }

    public TurmaDto atualiza(TurmaDto dto) {
        return converter.toDto(repository.save(converter.toEntity(dto)));
    }

    public void remove(Long id) {
        repository.deleteById(id);
    }

    public TurmaDto insereComSemestre(TurmaDto turmaDto, SemestreDto semestreDto) {

        TurmaEntity turmaEntity = repository.save(converter.toEntity(turmaDto));
        SemestreEntity semestreEntity = semestreConverter.toEntity(semestreDto);
        semestreEntity = semestreRepository.save(semestreEntity);;
        insereDiasLetivos(turmaEntity, semestreEntity);
        return converter.toDto(turmaEntity);
    }

    private void insereDiasLetivos(TurmaEntity turmaEntity, SemestreEntity semestreEntity) {
        List<DiaLetivoEntity> diasLetivos = new ArrayList<>();
        for (LocalDate date = semestreEntity.getDataInicio(); date.isBefore(semestreEntity.getDataFim()); date = date.plusDays(1)) {
            if (dataValidation.isNotDayOfWeekend(date)) {
                if (isNotFeriado(date)) {
                    for (DiaHoraAulaEntity diaHoraAula: turmaEntity.getDiaHoraAulas()) {
                        if (isDiaDeAula(date, diaHoraAula)) {
                            DiaLetivoEntity diaLetivoEntity = new DiaLetivoEntity();
                            diaLetivoEntity.setTurma(turmaEntity);
                            LocalDateTime dataHoraDaAula = LocalFormatter.appendDateAndTime(date, LocalFormatter.toLocalTime(diaHoraAula.getHora()));
                            diaLetivoEntity.setDataHora(dataHoraDaAula);
                            diasLetivos.add(diaLetivoEntity);
                        }
                    }
                }
            }
        }
        if (diasLetivos.size() > 0) {
            diaLetivoRepository.saveAll(diasLetivos);
        }
    }


    private boolean isDiaDeAula(LocalDate date, DiaHoraAulaEntity diaHoraAula) {
        return date.getDayOfWeek().toString().equals(diaHoraAula.getDia());
    }

    private boolean isNotFeriado(LocalDate date) {
        return !feriadoRepository.existsByData(date);
    }

    public boolean existePorId(Long idTurma) {
        return repository.existsById(idTurma);
    }

    public List<TurmaDto> buscaTodasAsTurmasPorIdAluno(Long idAluno) {
        Optional<AlunoEntity> aluno = alunoRepository.findById(idAluno);
        List<TurmaEntity> turmas;
        if (aluno.isPresent()) {
            turmas = repository.findAllbyAluno(aluno.get());
            return converter.toDtoList(turmas);
        } else {
            return new ArrayList<>();
        }
    }

    public TurmaDto buscaPorId(Long id) {
        Optional<TurmaEntity> turmaEntity = repository.findById(id);
        return turmaEntity.map(entity -> converter.toDto(entity)).orElse(null);
    }
}
