package br.com.ktrak.domain.services;

import br.com.ktrak.domain.dto.in.AtualizaAlunoDto;
import br.com.ktrak.domain.dto.out.ExibeAlunoDto;
import br.com.ktrak.domain.dto.in.InsereAlunoDto;
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

    public ExibeAlunoDto buscaPorId(Long id) {
        var aluno = repository.findById(id);
        ExibeAlunoDto dtoResponse = new ExibeAlunoDto();
        aluno.ifPresent(dtoResponse::toDto);
        return dtoResponse;
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

    public ExibeAlunoDto atualiza(AtualizaAlunoDto dto) {
        var entity = dto.toEntity();
        entity = repository.save(entity);
        ExibeAlunoDto dtoResponse = new ExibeAlunoDto();
        dtoResponse.toDto(entity);
        return dtoResponse;
    }

    public void remove(Long id) {
        repository.deleteById(id);
    }
}
