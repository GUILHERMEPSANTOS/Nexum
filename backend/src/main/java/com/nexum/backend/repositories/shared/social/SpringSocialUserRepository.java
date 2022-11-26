package com.nexum.backend.repositories.shared.social;

import com.nexum.backend.domain.social.SocialUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Repository
public interface SpringSocialUserRepository extends JpaRepository<SocialUserEntity, Long> {

    @Query("select su " +
            "from SocialUserEntity su " +
            "where su.user.id_usuario = :id_user")
    Collection<SocialUserEntity> listSocialNetworksByUser(@Param("id_user") Long id_user);

    @Query("select case " +
            "when (count(su) > 0) " +
            "then true " +
            "else false " +
            "end " +
            "from SocialUserEntity su " +
            "where su.user.id_usuario = :id_user " +
            "and su.social.id_social = :id_social")
    Boolean checkUserAlreadyHasSocialNetworkByIdSocialAndIdUser(
            @Param("id_user") Long id_user,
            @Param("id_social") Long id_social
    );

    @Modifying
    @Transactional
    @Query("update SocialUserEntity su " +
                "set su.user_url = :user_url " +
           "where su.user.id_usuario = :id_user " +
                "and su.social.id_social = :id_social")
    void updateSocialUser(
            @Param("id_user")   Long id_user,
            @Param("id_social") Long id_social,
            @Param("user_url")  String user_url
    );
}
