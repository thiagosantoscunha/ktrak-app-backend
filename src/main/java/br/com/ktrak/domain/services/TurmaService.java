package br.com.ktrak.domain.services;

import br.com.ktrak.Utils.AimbraFluentValidationApi.DataValidationImpl;
import br.com.ktrak.Utils.LocalFormatter;
import br.com.ktrak.domain.converters.SemestreConverter;
import br.com.ktrak.domain.converters.TurmaConverter;
import br.com.ktrak.domain.dto.DiaLetivoDto;
import br.com.ktrak.domain.dto.SemestreDto;
import br.com.ktrak.domain.dto.TurmaDto;
import br.com.ktrak.domain.dto.in.AtualizaTurmaDto;
import br.com.ktrak.domain.dto.in.InsereTurmaDto;
import br.com.ktrak.domain.dto.out.ExibeTurmaDto;
import br.com.ktrak.domain.dto.out.TurmaOutDto;
import br.com.ktrak.domain.entities.DiaHoraAulaEntity;
import br.com.ktrak.domain.entities.DiaLetivoEntity;
import br.com.ktrak.domain.entities.SemestreEntity;
import br.com.ktrak.domain.entities.TurmaEntity;
import br.com.ktrak.domain.repositories.DiaLetivoRepository;
import br.com.ktrak.domain.repositories.FeriadoRepository;
import br.com.ktrak.domain.repositories.SemestreRepository;
import br.com.ktrak.domain.repositories.TurmaRepository;
import br.com.ktrak.secretaria.validators.SemestreValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

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
    private FeriadoRepository feriadoRepository;

    public List<TurmaDto> buscaTudo() {
        var entities = repository.findAll();
        return converter.toDtoList(entities);
    }

    public TurmaDto insere(TurmaDto dto) {
        var entity = converter.toEntity(dto);
        entity = repository.save(entity);
        return converter.toDto(entity);
    }

    public TurmaDto atualiza(TurmaDto dto) {
        var entity = converter.toEntity(dto);
        return converter.toDto(repository.save(entity));
    }

    public void remove(Long id) {
        repository.deleteById(id);
    }

    public TurmaDto insereComSemestre(TurmaDto turmaDto, SemestreDto semestreDto) {
        var turmaEntity = converter.toEntity(turmaDto);
        turmaEntity = repository.save(turmaEntity);
        var semestreEntity = semestreConverter.toEntity(semestreDto);
        var semestreResponse = semestreRepository.findById(semestreEntity.getId());
        if (semestreResponse.isPresent()) {
            semestreEntity = semestreResponse.get();
        }
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
}
