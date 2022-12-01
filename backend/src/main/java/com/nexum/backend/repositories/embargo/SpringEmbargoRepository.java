package com.nexum.backend.repositories.embargo;

import com.nexum.backend.domain.embargo.Embargo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringEmbargoRepository extends JpaRepository<Embargo, String> {
    Optional<Embargo> findByFileName(String fileName);
}
