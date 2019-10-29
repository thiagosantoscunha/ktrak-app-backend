package br.com.ktrak;

import br.com.ktrak.Security.APIs.UserAPI;
import br.com.ktrak.Security.DTOs.UserListDTO;
import org.apache.catalina.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import javax.validation.constraints.AssertTrue;
import java.util.List;

@SpringBootTest
class KtrakApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void UserListTest() {
        UserAPI userAPI = new UserAPI();
        List<UserListDTO> users = userAPI.findAll();
        Assertions.assertEquals("codenome", users.get(0).username);
    }

}
