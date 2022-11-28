package com.nexum.backend.services.freelancer.interfaces;

import com.nexum.backend.dto.freelancer.habilidade.HabilidadeDTO;
import com.nexum.backend.dto.freelancer.habilidade.HabilidadeFreelancerDTO;
import com.nexum.backend.dto.freelancer.habilidade.request.HabilidadeFreelancerCreateRequest;

import java.util.Collection;

public interface HabilidadeFreelancerServicePort {
    Collection<HabilidadeFreelancerDTO> listHabilidadeByFreelancerId(Long id_freelancer);
    Boolean validateSkillAlreadyRegisteredToUser(Long id_freelancer, Long id_habilidade);
    void handleHabilidadeFreelancer(Collection<HabilidadeFreelancerCreateRequest> request);
}
