package com.ktrakapp.domain.entities.converters;

import com.ktrakapp.Utils.LocalFormatter;
import com.ktrakapp.domain.dto.ProfessorDto;
import com.ktrakapp.domain.entities.ProfessorEntity;
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
                professorDto.estado,
                professorDto.status
            ),
            professorEntity -> new ProfessorDto(
                professorEntity.getId(),
                professorEntity.getNome(),
                professorEntity.getDataNascimento().toString(),
                professorEntity.getCep(),
                professorEntity.getLogradouro(),
                professorEntity.getBairro(),
                professorEntity.getCidade(),
                professorEntity.getEstado(),
                professorEntity.getStatus()
            )
        );
    }

}
