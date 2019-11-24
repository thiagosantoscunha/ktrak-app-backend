package br.com.ktrak.security.services;

import br.com.ktrak.security.entities.UserEntity;
import br.com.ktrak.security.repositories.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private AuthRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity entity = Optional
                .ofNullable(
                        repository.findByUsername(username)
                ).orElseThrow(() -> new UsernameNotFoundException("Não foi possível encontrar este usuário"));
        List<GrantedAuthority> authorityList = AuthorityUtils.createAuthorityList("ROOT");
        return new User(entity.getUsername(), entity.getPassword(), authorityList);
    }
}
