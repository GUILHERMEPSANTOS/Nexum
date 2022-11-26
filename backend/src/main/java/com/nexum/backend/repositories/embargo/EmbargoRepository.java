package com.nexum.backend.repositories.embargo;

import com.nexum.backend.domain.embargo.Embargo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmbargoRepository extends JpaRepository<Embargo, String> {
}
