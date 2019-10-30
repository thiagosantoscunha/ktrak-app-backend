package br.com.ktrak.Utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class BodyResponse {
    public Object data;
    public String message;
}
