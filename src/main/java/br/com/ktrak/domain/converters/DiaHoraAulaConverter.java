package br.com.ktrak.domain.converters;

import br.com.ktrak.domain.dto.DiaHoraAulaDto;
import br.com.ktrak.domain.entities.DiaHoraAulaEntity;
import org.springframework.stereotype.Service;

@Service
public class DiaHoraAulaConverter extends Converter<DiaHoraAulaDto, DiaHoraAulaEntity> {


    public DiaHoraAulaConverter() {
        super(fromDto -> {
            DiaHoraAulaEntity entity = new DiaHoraAulaEntity();
            entity.setId(fromDto.id);
            entity.setDia(fromDto.dia);
            entity.setHora(fromDto.hora);
            return entity;
        }, fromEntity -> new DiaHoraAulaDto(
                fromEntity.getId(),
                fromEntity.getDia(),
                fromEntity.getHora()
        ));
    }
}
