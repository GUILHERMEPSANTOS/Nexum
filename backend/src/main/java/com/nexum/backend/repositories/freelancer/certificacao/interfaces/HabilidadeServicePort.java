package com.nexum.backend.repositories.freelancer.certificacao.interfaces;

import com.nexum.backend.controller.embargo.dto.freelancer.habilidade.HabilidadeDTO;
import com.nexum.backend.controller.embargo.dto.freelancer.habilidade.HabilidadeFreelancerDTO;

import java.util.Collection;

public interface HabilidadeServicePort {
    Collection<HabilidadeDTO> listAllHabilidades();
    Boolean existsHabilidadeById(Long id_habilidade);
    Collection<HabilidadeFreelancerDTO> listHabilidadeFreelancer(Long id_freelancer);
}
