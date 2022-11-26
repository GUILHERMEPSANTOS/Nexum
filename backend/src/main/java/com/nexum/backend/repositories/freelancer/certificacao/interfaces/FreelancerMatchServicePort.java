package com.nexum.backend.repositories.freelancer.certificacao.interfaces;

import com.nexum.backend.controller.embargo.dto.contratante.ContratanteDTO;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface FreelancerMatchServicePort {
    Collection<ContratanteDTO> getMatchsRequestByFreelancerId(@Param("id_freelancer") Long id_freelancer);
}
