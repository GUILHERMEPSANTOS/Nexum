package com.nexum.backend.repositories.controle.acesso;

import com.nexum.backend.domain.controle.acesso.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpringUserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmailAndSenha(String email, String senha);
    Optional<UserEntity> findByEmail(String email);



}
