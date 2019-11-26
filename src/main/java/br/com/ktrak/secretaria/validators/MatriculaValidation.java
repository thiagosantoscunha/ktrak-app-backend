package br.com.ktrak.secretaria.validators;

import br.com.ktrak.Utils.AimbraFluentValidationApi.ObjectValidationImpl;
import br.com.ktrak.domain.dto.MatriculaDto;
import br.com.ktrak.domain.exceptions.BadRequestException;
import br.com.ktrak.domain.services.AlunoService;
import br.com.ktrak.domain.services.MatriculaService;
import br.com.ktrak.domain.services.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MatriculaValidation {

    @Autowired
    private ObjectValidationImpl objectValidation;

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private TurmaService turmaService;

    @Autowired
    private MatriculaService matriculaService;

    public boolean isNaoPodeInserir(MatriculaDto dto) {
        objectValidation.isNull(dto.getAluno(), "Aluno não selecionado");

        if (!alunoService.existePorId(dto.getAluno().getId())) {
            throw new BadRequestException("Não foi possível encontrar o aluno");
        }

        objectValidation.isNull(dto.getTurma().getId(), "É preciso selecionar uma turma");

        if (!turmaService.existePorId(dto.getTurma().getId())) {
            throw new BadRequestException("Não foi possível encontrar a turma.");
        }

        List<MatriculaDto> matriculasDoAluno = matriculaService.buscaTudoPorAluno(dto.getAluno());

        if (!matriculasDoAluno.isEmpty()) {
            matriculasDoAluno.forEach(m -> {
                if (m.getTurma().equals(dto.getTurma()) || m.getAluno().equals(dto.getAluno())) {
                    throw new BadRequestException("Este aluno já esta cadastrado nesta turma");
                }
                m.getTurma().getDiaHoraAulas().forEach(i -> {
                    dto.getTurma().getDiaHoraAulas().forEach(j -> {
                        if (i.dia.equals(j.dia) && i.hora.equals(j.hora)) {
                            throw new BadRequestException("Você já preencheu este horário");
                        }
                    });
                });
            });
        }

        return false;
    }

    public boolean isNaoPodeAtualizar(MatriculaDto dto) {
        objectValidation.isNull(dto.getId(), "Matricula sem ID");
        return isNaoPodeInserir(dto);
    }
}
