package br.com.ktrak.security.api;


import br.com.ktrak.domain.dto.AlunoDto;
import br.com.ktrak.domain.dto.PessoaDto;
import br.com.ktrak.security.dto.UserDto;
import br.com.ktrak.security.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "v1/auth")
public class AuthApi {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AlunoDto> login(@RequestBody UserDto dto) {
        System.out.println(dto);
        var pessoa = authService.login(dto);
        return ResponseEntity.ok(pessoa);
    }

}