package br.com.ktrak.domain.converters;

import br.com.ktrak.Utils.LocalFormatter;
import br.com.ktrak.domain.dto.ProfessorDto;
import br.com.ktrak.domain.entities.ProfessorEntity;
import org.springframework.stereotype.Service;

@Service
public class ProfessorConverter extends Converter<ProfessorDto, ProfessorEntity> {


    public ProfessorConverter() {
        super(
            professorDto -> new ProfessorEntity(
                professorDto.id,
                professorDto.nome,
                LocalFormatter.toLocalDate(professorDto.dataNascimento),
                professorDto.cep,
                professorDto.logradouro,
                professorDto.bairro,
                professorDto.cidade,
                professorDto.estado
            ),
            professorEntity -> new ProfessorDto(
                professorEntity.getId(),
                professorEntity.getNome(),
                professorEntity.getDataNascimento().toString(),
                professorEntity.getCep(),
                professorEntity.getLogradouro(),
                professorEntity.getBairro(),
                professorEntity.getCidade(),
                professorEntity.getEstado()
            )
        );
    }

}
