package br.com.ktrak.domain.services;

import br.com.ktrak.domain.dto.ExibeProfessorDto;
import br.com.ktrak.domain.dto.InsereProfessorDto;
import br.com.ktrak.domain.entities.ProfessorEntity;
import br.com.ktrak.domain.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProfessorService implements Serializable {

    @Autowired
    private ProfessorRepository repository;

    public List<ExibeProfessorDto> buscaTudo() {
        var professorResponseList = repository.findAll();

        List<ExibeProfessorDto> professores = new ArrayList<>();

        professorResponseList.forEach(prof -> {
            ExibeProfessorDto model = new ExibeProfessorDto();
            model.toDto(prof);
            professores.add(model);
        });

        return professores;
    }

    public ExibeProfessorDto insere(InsereProfessorDto model) {
        var entity = model.toEntity();
        entity = repository.save(entity);
        ExibeProfessorDto dto = new ExibeProfessorDto();
        dto.toDto(entity);
        return dto;
    }
}
