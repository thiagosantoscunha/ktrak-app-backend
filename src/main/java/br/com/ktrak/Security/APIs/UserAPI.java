package br.com.ktrak.Security.APIs;

import br.com.ktrak.Security.DTOs.UserListDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import static java.util.Arrays.asList;

@RestController
@RequestMapping("v1/users")
public class UserAPI {
    @RequestMapping(method = RequestMethod.GET, path = "")
    public List<UserListDTO> findAll() {
        return asList(
                new UserListDTO(1L, "codenome", LocalDateTime.now(), LocalDateTime.now()),
                new UserListDTO(1L, "thiagosantoscunha", LocalDateTime.now(), LocalDateTime.now())
        );
    }
}
