package com.nexum.backend.services.freelancer.interfaces;

import com.nexum.backend.dto.freelancer.habilidade.HabilidadeDTO;

import java.util.Collection;

public  interface HabilidadeServicePort {
    Collection<HabilidadeDTO> listAllHabilidades();
    Boolean existsHabilidadeById(Long id_habilidade);
    HabilidadeDTO getHabilidadeById(Long id_habilidade);
}
