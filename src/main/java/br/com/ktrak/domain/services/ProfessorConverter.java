package br.com.ktrak.domain.services;

import br.com.ktrak.Utils.AimbraFluentValidationApi.NumberValidationImpl;
import br.com.ktrak.Utils.LocalDateTimeFormatter;
import br.com.ktrak.domain.dto.ProfessorDto;
import br.com.ktrak.domain.dto.out.ExibeProfessorDto;
import br.com.ktrak.domain.entities.ProfessorEntity;
import br.com.ktrak.domain.services.interfaces.DtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class ProfessorConverter implements DtoConverter<ProfessorDto, ProfessorEntity> {

    @Autowired
    NumberValidationImpl validation;

    @Override
    public ProfessorDto toDto(ProfessorEntity entity) {
        ProfessorDto dto = new ProfessorDto();
        dto.id = entity.getId();
        dto.nome = entity.getNome();
        dto.dataNascimento = entity.getDataNascimento().toString();
        dto.logradouro = entity.getLogradouro();
        dto.bairro = entity.getBairro();
        dto.cidade = entity.getCidade();
        dto.estado = entity.getEstado();
        dto.cep = entity.getCep();
        return dto;
    }

    @Override
    public ProfessorEntity toEntity(ProfessorDto dto) {
        ProfessorEntity entity = new ProfessorEntity();
        if (validation.isNotNull(dto.id)) entity.setId(dto.id);
        entity.setNome(dto.nome);
        entity.setDataNascimento(LocalDateTimeFormatter.toLocalDate(dto.dataNascimento));
        entity.setLogradouro(dto.logradouro);
        entity.setBairro(dto.bairro);
        entity.setCidade(dto.cidade);
        entity.setEstado(dto.estado);
        entity.setCep(dto.cep);
        return entity;
    }

    @Override
    public List<ProfessorDto> toDtoList(Iterable<ProfessorEntity> entities) {
        List<ProfessorDto> dtoList = new ArrayList<>();
        entities.forEach(e -> {
            dtoList.add(toDto(e));
        });
        return dtoList;
    }

}
