package com.nexum.backend.repositories.freelancer.habilidade;

import com.nexum.backend.domain.habilidade.HabilidadeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringHabilidadeRepository extends JpaRepository<HabilidadeEntity, Long> {
}
