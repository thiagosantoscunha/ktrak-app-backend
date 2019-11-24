package br.com.ktrak.domain.converters;

import br.com.ktrak.Utils.LocalFormatter;
import br.com.ktrak.domain.dto.AlunoDto;
import br.com.ktrak.domain.dto.PessoaDto;
import br.com.ktrak.domain.entities.AlunoEntity;
import br.com.ktrak.domain.entities.PessoaEntity;
import org.springframework.stereotype.Service;

@Service
public class PessoaConverter extends Converter<PessoaDto, PessoaEntity> {
    public PessoaConverter() {
        super(fromDto -> {
            PessoaEntity entity = new PessoaEntity();
            entity.setId(fromDto.getId());
            entity.setNome(fromDto.getNome());
            entity.setDataNascimento(LocalFormatter.toLocalDate(fromDto.getDataNascimento()));
            entity.setCep(fromDto.getCep());
            entity.setLogradouro(fromDto.getLogradouro());
            entity.setBairro(fromDto.getBairro());
            entity.setCidade(fromDto.getCidade());
            entity.setEstado(fromDto.getEstado());
            return entity;
        },
        fromEntity -> new PessoaDto(
            fromEntity.getId(),
            fromEntity.getNome(),
            fromEntity.getDataNascimento().toString(),
            fromEntity.getCep(),
            fromEntity.getLogradouro(),
            fromEntity.getBairro(),
            fromEntity.getCidade(),
            fromEntity.getEstado()
        ));
    }
}
