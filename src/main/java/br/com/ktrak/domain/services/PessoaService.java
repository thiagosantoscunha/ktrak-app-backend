package br.com.ktrak.domain.services;

import br.com.ktrak.domain.converters.PessoaConverter;
import br.com.ktrak.domain.dto.PessoaDto;
import br.com.ktrak.domain.entities.PessoaEntity;
import br.com.ktrak.domain.repositories.PessoaRepository;
import br.com.ktrak.security.repositories.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    @Autowired
    private AuthRepository authRepository;

    @Autowired
    private PessoaConverter converter;

    public PessoaDto buscaPorUsername(String username) {
        var user = authRepository.findByUsername(username);
        System.out.println(user);
        var pessoa = repository.findByUser(user);
        return converter.toDto(pessoa);
    }

}
