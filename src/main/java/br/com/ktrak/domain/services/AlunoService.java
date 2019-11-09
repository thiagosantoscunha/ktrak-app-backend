package br.com.ktrak.domain.services;

import br.com.ktrak.domain.dto.ExibeAlunoDto;
import br.com.ktrak.domain.dto.InsereAlunoDto;
import br.com.ktrak.domain.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Service
public class AlunoService implements Serializable {

    @Autowired
    private AlunoRepository repository;

    public List<ExibeAlunoDto> buscaTudo() {
        var alunos = repository.findAll();
        List<ExibeAlunoDto> dtoList = new ArrayList<>();

        alunos.forEach(aluno -> {
            var alunoDto = new ExibeAlunoDto();
            alunoDto.toDto(aluno);
            dtoList.add(alunoDto);
        });

        return dtoList;
    }

    public ExibeAlunoDto insere(InsereAlunoDto dto) {
        var entity = dto.toEntity();
        entity = repository.save(entity);
        ExibeAlunoDto dtoResponse = new ExibeAlunoDto();
        dtoResponse.toDto(entity);
        return dtoResponse;
    }

    public boolean existePorId(Long id) {
        return repository.existsById(id);
    }
}
