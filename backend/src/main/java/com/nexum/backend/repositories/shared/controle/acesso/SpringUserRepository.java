package com.nexum.backend.repositories.shared.controle.acesso;

import com.nexum.backend.domain.controle.acesso.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface SpringUserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmailAndSenha(String email, String senha);

    Optional<UserEntity> findByEmail(String email);

    @Modifying
    @Transactional
    @Query("update UserEntity u set u.sobre = :sobre where u.id_usuario = :id_user")
    void updateAboutUser(@Param("sobre") String sobre, @Param("id_user") Long id_user);
}
