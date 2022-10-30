package com.nexum.backend.repositories.social;

import com.nexum.backend.domain.social.SocialEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringSocialRepository extends JpaRepository<SocialEntity, Long> {
}
