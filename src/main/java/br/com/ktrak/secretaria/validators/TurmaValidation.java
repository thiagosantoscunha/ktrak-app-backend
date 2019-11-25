package br.com.ktrak.secretaria.validators;

import br.com.ktrak.Utils.AimbraFluentValidationApi.*;
import br.com.ktrak.domain.dto.TurmaDto;
import br.com.ktrak.domain.dto.in.InsereTurmaDto;
import br.com.ktrak.domain.exceptions.BadRequestException;
import br.com.ktrak.domain.repositories.DiaHoraAulaRepository;
import br.com.ktrak.domain.services.FeriadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TurmaValidation {

    @Autowired
    private ObjectValidationImpl objectValidation;

    @Autowired
    private DiaHoraAulaValidation horaAulaValidation;

    @Autowired
    private DataValidationImpl dataValidation;

    @Autowired
    private DiaHoraAulaRepository diaHoraAulaRepository;


    public boolean isNaoPodeInserir(TurmaDto dto) {
        objectValidation.isNull(dto.getProfessor(), "É preciso selecionar um professor para a turma");
        objectValidation.isNull(dto.getDisciplina(), "É preciso selecionar uma disciplina para a turma");

        objectValidation.isNull(dto.getDiaHoraAulas(), "É preciso selecionar pelo menos um dia e hora da aula");

        if (dto.getDiaHoraAulas().size() > 2) {
            throw new BadRequestException("Só é possível selecionar até 2 horarios");
        }

        dto.getDiaHoraAulas().forEach(o -> {
            horaAulaValidation.isNaoPodeInserir(o);

//            if (diaHoraAulaRepository.existsByDiaAndHora(o.dia, o.hora)) {
//                throw new BadRequestException("Este dia já esta cadastrado por outra turma.");
//            }

            dataValidation.isDayOfWeekend(o.dia, "Não pode selecionar fim de semana para a aula");

        });

        return false;
    }

    public boolean isNaoPodeAtualizar(TurmaDto dto) {
        objectValidation.isNull(dto.getId(), "Id da turma esta vazia");
        return isNaoPodeInserir(dto);
    }
}
