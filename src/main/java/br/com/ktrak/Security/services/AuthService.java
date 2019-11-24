package br.com.ktrak.security.services;

import br.com.ktrak.domain.converters.AlunoConverter;
import br.com.ktrak.domain.converters.PessoaConverter;
import br.com.ktrak.domain.dto.AlunoDto;
import br.com.ktrak.domain.dto.PessoaDto;
import br.com.ktrak.domain.entities.AlunoEntity;
import br.com.ktrak.domain.exceptions.BadRequestException;
import br.com.ktrak.domain.repositories.AlunoRepository;
import br.com.ktrak.domain.repositories.PessoaRepository;
import br.com.ktrak.security.dto.UserDto;
import br.com.ktrak.security.repositories.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthRepository authRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private AlunoConverter alunoConverter;

    public AlunoDto login(UserDto userDto) {
        var user = authRepository.findByUsername(userDto.username);
        if (!user.getPassword().equals(userDto.password)) {
            throw new BadRequestException("Usuário ou senha inválida");
        }
        var pessoa = pessoaRepository.findByUser(user);
        return alunoConverter.toDto((AlunoEntity) pessoa);
    }
}
