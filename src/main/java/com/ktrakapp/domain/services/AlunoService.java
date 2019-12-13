package com.ktrakapp.domain.services;

import com.ktrakapp.domain.dto.AlunoDto;
import com.ktrakapp.domain.entities.AlunoEntity;
import com.ktrakapp.domain.entities.converters.AlunoConverter;
import com.ktrakapp.domain.repositories.AlunoRepository;
import com.ktrakapp.security.entities.UserEntity;
import com.ktrakapp.security.repositories.AuthRepository;
import com.ktrakapp.security.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoService implements Serializable {

    @Autowired
    private AlunoRepository repository;

    @Autowired
    private AlunoConverter converter;

    @Autowired
    private AuthRepository authRepository;

    @Autowired
    private AuthService authService;

    public List<AlunoDto> buscaTudo() {
        List<AlunoEntity> alunos = repository.findAllByOrderByNomeAsc();
        return converter.toDtoList(alunos);
    }

    public AlunoDto buscaPorId(Long id) {
        Optional<AlunoEntity> aluno = repository.findById(id);
        return aluno.map(e -> converter.toDto(e)).orElse(null);
    }

    public AlunoDto insere(AlunoDto dto) {
        UserEntity userResponseEntity = authService.saveByAluno(dto);
        AlunoEntity entity = converter.toEntity(dto);
        entity.setUser(userResponseEntity);
        entity = repository.save(entity);
        return converter.toDto(entity);
    }

    public boolean existePorId(Long id) {
        return repository.existsById(id);
    }

    public AlunoDto atualiza(AlunoDto dto) {
        AlunoEntity entity = converter.toEntity(dto);
        UserEntity user = authRepository.findByPessoa(entity.getId());
        entity.setUser(user);
        entity = repository.save(entity);
        return converter.toDto(entity);
    }

    public void remove(Long id) {
        repository.deleteById(id);
    }

    public List<AlunoDto> buscaTudoPorNome(String nome) {
        List<AlunoEntity> alunos = this.repository.findByNomeContainingIgnoreCase(nome);
        return converter.toDtoList(alunos);
    }

    public AlunoDto buscaPorUsername(String username) {
        AlunoEntity response = repository.findByUsername(username);
        return converter.toDto(response);
    }
}
