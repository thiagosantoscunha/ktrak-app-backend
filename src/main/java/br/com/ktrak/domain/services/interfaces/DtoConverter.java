package br.com.ktrak.domain.services.interfaces;

import java.util.Collection;
import java.util.List;

public interface DtoConverter<Dto, Entity> {

    Dto toDto(Entity entity);
    Entity toEntity(Dto dto);
    List<Dto> toDtoList(Iterable<Entity> entities);

}
