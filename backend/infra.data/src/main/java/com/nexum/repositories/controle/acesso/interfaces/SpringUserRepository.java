package com.nexum.repositories.controle.acesso.interfaces;

import com.nexum.entities.controle.acesso.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpringUserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByNome(String nome);
}
