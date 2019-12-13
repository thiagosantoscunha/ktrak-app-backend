package com.ktrakapp.domain.entities.converters;

import com.ktrakapp.Utils.LocalFormatter;
import com.ktrakapp.domain.dto.AlunoDto;
import com.ktrakapp.domain.entities.AlunoEntity;
import org.springframework.stereotype.Service;

@Service
public class AlunoConverter extends Converter<AlunoDto, AlunoEntity> {
    public AlunoConverter() {
        super(
                alunoDto -> new AlunoEntity(
                    alunoDto.getId(),
                    alunoDto.getNome(),
                    LocalFormatter.toLocalDate(alunoDto.getDataNascimento()),
                    alunoDto.getCep(),
                    alunoDto.getLogradouro(),
                    alunoDto.getBairro(),
                    alunoDto.getCidade(),
                    alunoDto.getEstado(),
                    alunoDto.getStatus()
                ),
                alunoEntity -> new AlunoDto(
                    alunoEntity.getId(),
                    alunoEntity.getNome(),
                    alunoEntity.getDataNascimento().toString(),
                    alunoEntity.getCep(),
                    alunoEntity.getLogradouro(),
                    alunoEntity.getBairro(),
                    alunoEntity.getCidade(),
                    alunoEntity.getEstado(),
                    alunoEntity.getStatus()
                )
        );
    }
}
