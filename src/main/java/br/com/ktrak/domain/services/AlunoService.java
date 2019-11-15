package br.com.ktrak.domain.services;

import br.com.ktrak.domain.converters.AlunoConverter;
import br.com.ktrak.domain.dto.AlunoDto;
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

    @Autowired
    private AlunoConverter converter;

    public List<AlunoDto> buscaTudo() {
        var alunos = repository.findAll();
        return converter.toDtoList(alunos);
    }

    public AlunoDto buscaPorId(Long id) {
        var aluno = repository.findById(id);
        return aluno.map(e -> converter.toDto(e)).orElse(null);
    }

    public AlunoDto insere(AlunoDto dto) {
        var entity = converter.toEntity(dto);
        entity = repository.save(entity);
        return converter.toDto(entity);
    }

    public boolean existePorId(Long id) {
        return repository.existsById(id);
    }

    public AlunoDto atualiza(AlunoDto dto) {
        var entity = converter.toEntity(dto);
        entity = repository.save(entity);
        return converter.toDto(entity);
    }

    public void remove(Long id) {
        repository.deleteById(id);
    }
}
