package com.nexum.backend.repositories.controle.acesso;

import com.nexum.backend.domain.controle.acesso.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpringUserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmailAndSenha(String email, String senha);
    Optional<UserEntity> findByEmail(String email);

}
