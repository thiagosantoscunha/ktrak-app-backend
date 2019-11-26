package br.com.ktrak.domain.services;

import br.com.ktrak.Utils.EstadoUtil;
import br.com.ktrak.domain.converters.AlunoConverter;
import br.com.ktrak.domain.converters.UserConverter;
import br.com.ktrak.domain.dto.AlunoDto;
import br.com.ktrak.domain.dto.TurmaDto;
import br.com.ktrak.domain.dto.in.AtualizaAlunoDto;
import br.com.ktrak.domain.dto.out.ExibeAlunoDto;
import br.com.ktrak.domain.dto.in.InsereAlunoDto;
import br.com.ktrak.domain.entities.AlunoEntity;
import br.com.ktrak.domain.repositories.AlunoRepository;
import br.com.ktrak.security.dto.UserDto;
import br.com.ktrak.security.entities.UserEntity;
import br.com.ktrak.security.repositories.AuthRepository;
import br.com.ktrak.security.services.AuthService;
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

    @Autowired
    private AuthRepository authRepository;

    @Autowired
    private AuthService authService;

    public List<AlunoDto> buscaTudo() {
        var alunos = repository.findAllByOrderByNomeAsc();
        return converter.toDtoList(alunos);
    }

    public AlunoDto buscaPorId(Long id) {
        var aluno = repository.findById(id);
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
