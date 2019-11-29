package br.com.ktrak.security.api;


import br.com.ktrak.domain.dto.AlunoLogadoDto;
import br.com.ktrak.domain.dto.UserRequestDto;
import br.com.ktrak.security.dto.UserDto;
import br.com.ktrak.security.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "v1/auth")
public class AuthApi {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AlunoLogadoDto> login(@RequestBody UserRequestDto request) {
        return ResponseEntity.ok(authService.login(request));
    }

}
