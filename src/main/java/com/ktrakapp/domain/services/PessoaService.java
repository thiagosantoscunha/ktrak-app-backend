package com.ktrakapp.domain.services;

import com.ktrakapp.domain.dto.PessoaDto;
import com.ktrakapp.domain.entities.converters.PessoaConverter;
import com.ktrakapp.domain.repositories.PessoaRepository;
import com.ktrakapp.security.entities.UserEntity;
import com.ktrakapp.security.repositories.AuthRepository;
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
        UserEntity response = authRepository.findByUsername(username);
        return converter.toDto(
                repository.findByUser(
                        response
                )
        );
    }

}
