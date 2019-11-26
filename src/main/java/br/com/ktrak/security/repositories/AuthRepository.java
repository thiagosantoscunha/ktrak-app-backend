package br.com.ktrak.security.repositories;

import br.com.ktrak.domain.entities.AlunoEntity;
import br.com.ktrak.domain.entities.PessoaEntity;
import br.com.ktrak.security.entities.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);

    @Query(value = "select * from users as u join pessoas as p on p.user_id = u.id where p.id = :id", nativeQuery = true)
    UserEntity findByPessoa(@Param("id") Long id);
}
