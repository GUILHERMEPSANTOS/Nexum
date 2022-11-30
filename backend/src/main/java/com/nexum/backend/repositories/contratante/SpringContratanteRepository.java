package com.nexum.backend.repositories.contratante;

import com.nexum.backend.domain.controle.acesso.ContratanteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SpringContratanteRepository extends JpaRepository<ContratanteEntity, Long> {
    @Query("select count(*) from ContratanteEntity")
    Integer countNumberContratantes();
}