package com.nexum.backend.services.freelancer.interfaces;

import com.nexum.backend.dto.freelancer.habilidade.HabilidadeDTO;
import com.nexum.backend.dto.freelancer.habilidade.HabilidadeFreelancerDTO;

import java.util.Collection;

public interface HabilidadeFreelancerServicePort {
    Collection<HabilidadeDTO> listAllHabilidades();
    Boolean existsHabilidadeById(Long id_habilidade);
    Collection<HabilidadeFreelancerDTO> listHabilidadeFreelancerId(Long id_freelancer);
    Boolean validateSkillAlreadyRegisteredToUser(Long id_freelancer, Long id_habilidade);
    void handleHabilidadeFreelancer(Long id_freelancer, Long id_habilidade);

//    void addHabilidadeToFreelancer();
//    void updateHabilidadeFreelancer();
}
