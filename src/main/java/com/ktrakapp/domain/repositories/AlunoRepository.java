package com.ktrakapp.domain.repositories;

import com.ktrakapp.domain.entities.AlunoEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends CrudRepository<AlunoEntity, Long> {
    List<AlunoEntity> findAllByOrderByNomeAsc();
    List<AlunoEntity> findByNomeContainingIgnoreCase(String nome);

    @Query("select p from PessoaEntity p join UserEntity u on p = u where u.username = :username")
    AlunoEntity findByUsername(@Param("username") String username);
}
