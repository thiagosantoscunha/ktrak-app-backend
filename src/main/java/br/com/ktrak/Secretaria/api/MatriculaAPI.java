package br.com.ktrak.secretaria.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/matriculas")
public class MatriculaAPI {

    @RequestMapping(method = RequestMethod.GET, path = "")
    public List<Object> findAll() {
        return null;
    }
}
