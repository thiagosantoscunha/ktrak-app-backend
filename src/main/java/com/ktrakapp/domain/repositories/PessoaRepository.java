package com.ktrakapp.domain.repositories;

import com.ktrakapp.domain.entities.PessoaEntity;
import com.ktrakapp.security.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends CrudRepository<PessoaEntity, Long> {
    PessoaEntity findByUser(UserEntity user);
}
