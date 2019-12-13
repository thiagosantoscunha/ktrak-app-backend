package com.ktrakapp.security.api;


import com.ktrakapp.domain.dto.AlunoLogadoDto;
import com.ktrakapp.domain.dto.UserRequestDto;
import com.ktrakapp.security.services.AuthService;
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
    public ResponseEntity<AlunoLogadoDto> login(@RequestBody UserRequestDto request) {
        return ResponseEntity.ok(authService.login(request));
    }

}
