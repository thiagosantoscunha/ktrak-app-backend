package br.com.ktrak.security.repositories;

import br.com.ktrak.security.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
}
