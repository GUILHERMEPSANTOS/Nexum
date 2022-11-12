package com.nexum.backend.repositories.contratante;

import com.nexum.backend.domain.controle.acesso.ContratanteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringContratanteRepository extends JpaRepository<ContratanteEntity, Long> {
}