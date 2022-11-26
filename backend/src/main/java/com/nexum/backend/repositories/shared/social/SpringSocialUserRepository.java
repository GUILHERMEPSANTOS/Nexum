package com.nexum.backend.repositories.shared.social;

import com.nexum.backend.domain.social.SocialUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringSocialUserRepository extends JpaRepository<SocialUserEntity, Long> {
}
