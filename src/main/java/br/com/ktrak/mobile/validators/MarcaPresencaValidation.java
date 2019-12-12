package br.com.ktrak.mobile.validators;

import br.com.ktrak.Utils.AimbraFluentValidationApi.DataValidationImpl;
import br.com.ktrak.Utils.AimbraFluentValidationApi.TextValidationImpl;
import br.com.ktrak.domain.dto.AlunoDto;
import br.com.ktrak.domain.dto.MarcaPresencaDto;
import br.com.ktrak.domain.exceptions.NotFoundException;
import br.com.ktrak.domain.services.AlunoService;
import br.com.ktrak.domain.services.RecessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class MarcaPresencaValidation {

    @Autowired
    private TextValidationImpl textValidation;

    @Autowired
    private DataValidationImpl dataValidation;

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private RecessoService recessoService;

    public boolean isNaoPodeMarcarPresenca(MarcaPresencaDto dto) {

        textValidation.isNullOrEmpty(dto.getUsername(), "Aluno esta vazio");
        textValidation.isNullOrEmpty(dto.getKey(), "A chave esta vazia");
        dataValidation.isDayOfWeekend(LocalDate.now() ,"Este dia é um final de semana");
        boolean existeRecesso =recessoService.existePorData((LocalDate.now().getYear()+"-"+LocalDate.now().getMonth()+"-"+LocalDate.now().getDayOfMonth()));
        if (existeRecesso) {
            throw new NotFoundException("Este dia é um feriado");
        }
        AlunoDto alunoExiste=null;
        alunoExiste = alunoService.buscaPorUsername(dto.getUsername());
        if (alunoExiste==null){
            throw new NotFoundException("Este username não existe");
        }

        return false;
    }


}
