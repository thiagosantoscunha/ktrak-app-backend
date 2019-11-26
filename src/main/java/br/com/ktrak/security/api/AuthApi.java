package br.com.ktrak.security.api;


import br.com.ktrak.domain.dto.AlunoDto;
import br.com.ktrak.domain.dto.PessoaDto;
import br.com.ktrak.security.dto.PayloadDto;
import br.com.ktrak.security.dto.UserDto;
import br.com.ktrak.security.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "v1/auth")
public class AuthApi {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AlunoDto> login(@RequestBody UserDto dto) {
        return ResponseEntity.ok(authService.login(dto));
    }

    @GetMapping
    public ResponseEntity<?> buscaUsuario(@AuthenticationPrincipal() UserDetails userDetails) {
        System.out.println(userDetails);
        return ResponseEntity.ok(userDetails);
    }

}
