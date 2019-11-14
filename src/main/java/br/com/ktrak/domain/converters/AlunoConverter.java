package br.com.ktrak.domain.converters;

import br.com.ktrak.Utils.LocalDateTimeFormatter;
import br.com.ktrak.domain.dto.AlunoDto;
import br.com.ktrak.domain.entities.AlunoEntity;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class AlunoConverter extends Converter<AlunoDto, AlunoEntity> {
    public AlunoConverter() {
        super(
                alunoDto -> new AlunoEntity(
                    alunoDto.id,
                    alunoDto.nome,
                    LocalDateTimeFormatter.toLocalDate(alunoDto.dataNascimento),
                    alunoDto.cep,
                    alunoDto.logradouro,
                    alunoDto.bairro,
                    alunoDto.cidade,
                    alunoDto.estado
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
