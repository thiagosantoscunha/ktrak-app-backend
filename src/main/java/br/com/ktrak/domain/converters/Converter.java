package br.com.ktrak.domain.converters;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class Converter<DTO, ENTITY> {

    private final Function<DTO, ENTITY> fromDto;
    private final Function<ENTITY, DTO> fromEntity;

    public Converter(Function<DTO, ENTITY> fromDto, Function<ENTITY, DTO> fromEntity) {
        this.fromDto = fromDto;
        this.fromEntity = fromEntity;
    }

    public final ENTITY toEntity(final DTO dto) {
        return fromDto.apply(dto);
    }

    public final DTO toDto(final ENTITY entity) {
        return fromEntity.apply(entity);
    }

    public final List<ENTITY> toEntityList(final Collection<DTO> dtos) {
        return dtos.stream().map(this::toEntity).collect(Collectors.toList());
    }

    public final List<DTO> toDtoList(final Collection<ENTITY> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    public final List<DTO> toDtoList(final Iterable<ENTITY> entities) {
        List<DTO> dtos = new ArrayList<>();
        entities.forEach(e -> dtos.add(toDto(e)));
        return dtos;
    }

}
