package com.nexum.backend.repositories.match;

import com.nexum.backend.domain.match.MatchEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringMatchRepository extends JpaRepository<MatchEntity, Long> {
}
