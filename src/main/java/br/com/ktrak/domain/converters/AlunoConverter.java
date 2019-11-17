package br.com.ktrak.domain.converters;

import br.com.ktrak.Utils.LocalFormatter;
import br.com.ktrak.domain.dto.AlunoDto;
import br.com.ktrak.domain.entities.AlunoEntity;
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
                    alunoDto.getEstado()
                ),
                alunoEntity -> new AlunoDto(
                    alunoEntity.getId(),
                    alunoEntity.getNome(),
                    alunoEntity.getDataNascimento().toString(),
                    alunoEntity.getCep(),
                    alunoEntity.getLogradouro(),
                    alunoEntity.getBairro(),
                    alunoEntity.getCidade(),
                    alunoEntity.getEstado()
                )
        );
    }
}
