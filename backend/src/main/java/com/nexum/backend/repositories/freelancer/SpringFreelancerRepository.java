package com.nexum.backend.domain.certificacao.freelancer;

import com.nexum.backend.domain.controle.acesso.FreelancerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringFreelancerRepository extends JpaRepository<FreelancerEntity, Long> {
}
