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
    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM UserEntity u WHERE u.id_usuario = :id")
    boolean existsById(@Param("id") Long id);

    Optional<UserEntity> findByEmailAndSenha(String email, String senha);

    Optional<UserEntity> findByEmail(String email);

    @Query("select u.sobre from UserEntity u where u.id_usuario = :id_user")
    String getAboutUser(@Param("id_user") Long id_user);

    @Modifying
    @Transactional
    @Query("update UserEntity u set u.sobre = :sobre where u.id_usuario = :id_user")
    void updateAboutUser(@Param("sobre") String sobre, @Param("id_user") Long id_user);
}
