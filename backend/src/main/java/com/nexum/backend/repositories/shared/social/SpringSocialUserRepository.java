package com.nexum.backend.repositories.shared.social;

import com.nexum.backend.domain.social.SocialUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface SpringSocialUserRepository extends JpaRepository<SocialUserEntity, Long> {

    @Query("select su " +
           "from SocialUserEntity su " +
           "where su.user.id_usuario = :id_user")
    Collection<SocialUserEntity> listSocialNetworksByUser(@Param("id_user") Long id_user);
}
