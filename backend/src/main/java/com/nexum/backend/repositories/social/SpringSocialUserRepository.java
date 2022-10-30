package com.nexum.backend.repositories.social;

import com.nexum.backend.domain.social.SocialUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringSocialUserRepository extends JpaRepository<SocialUserEntity, Long> {
}
