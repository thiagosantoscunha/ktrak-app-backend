package br.com.ktrak.Utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Component
public class ResponseRest {
    public ResponseEntity<Object> answerGet(Object object) {
        return ResponseEntity.ok().body(object);
    }

    public  ResponseEntity<Object> answerPost(Object object, Long id) {
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();

        return ResponseEntity.created(uri).body(object);
    }

    public ResponseEntity<Object> answerPostList(Object object) {
        return ResponseEntity.ok().body(object);
    }

    public  ResponseEntity<Object> answerPut() {
        return ResponseEntity.noContent().build();
    }

    public  ResponseEntity<Object> answerDelete() {
        return ResponseEntity.noContent().build();
    }

    public  ResponseEntity<Object> answerNotFound(String mensagem) {

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorResult(mensagem));
    }

    public  ResponseEntity<Object> answerBadRequest(String mensagem) {

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorResult(mensagem));
    }

}
