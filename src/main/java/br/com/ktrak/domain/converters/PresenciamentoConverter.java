package br.com.ktrak.domain.converters;

import br.com.ktrak.domain.dto.PresenciamentoDto;
import br.com.ktrak.domain.entities.PresenciamentoEntity;
import org.springframework.stereotype.Service;

@Service
public class PresenciamentoConverter extends Converter<PresenciamentoDto, PresenciamentoEntity> {
    public PresenciamentoConverter() {
        super(fromDto -> {
            PresenciamentoEntity entity = new PresenciamentoEntity();
            entity.setId(fromDto.getId());
            entity.setIsPresente(fromDto.getIsPresente());
            entity.setMatricula(new MatriculaConverter().toEntity(fromDto.getMatricula()));
            entity.setDiaLetivo(new DiaLetivoConverter().toEntity(fromDto.getDiaLetivo()));
            return entity;
        }, fromEntity -> {
            PresenciamentoDto dto = new PresenciamentoDto();
            dto.setId(fromEntity.getId());
            dto.setIsPresente(fromEntity.getIsPresente());
            dto.setMatricula(new MatriculaConverter().toDto(fromEntity.getMatricula()));
            dto.setDiaLetivo(new DiaLetivoConverter().toDto(fromEntity.getDiaLetivo()));
            return dto;
        });
    }
}
