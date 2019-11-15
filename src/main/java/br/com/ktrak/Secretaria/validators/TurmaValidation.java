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
    private DiaHoraAulaRepository diaHoraAulaRepository;


    public boolean isNaoPodeInserir(TurmaDto dto) {
        objectValidation.isNotNull(dto.professor, "É preciso selecionar um professor para a turma");
        objectValidation.isNotNull(dto.disciplina, "É preciso selecionar uma disciplina para a turma");

        objectValidation.isNotNull(dto.diaHoraAulas, "É preciso selecionar pelo menos um dia e hora da aula");

        if (dto.diaHoraAulas.size() > 2) {
            throw new BadRequestException("Só é possível selecionar até 2 horarios");
        }

        dto.diaHoraAulas.forEach(o -> {
            horaAulaValidation.isNaoPodeInserir(o);

            if (diaHoraAulaRepository.existsByDiaAndHora(o.dia, o.hora)) {
                throw new BadRequestException("Este dia já esta cadastrado por outra turma.");
            }

            if (o.dia.equals("SATURDAY") || o.dia.equals("SUNDAY")) {
                throw new BadRequestException("Não pode selecionar sabado ou domingo como dia da aula");
            }

        });

        return false;
    }

}
