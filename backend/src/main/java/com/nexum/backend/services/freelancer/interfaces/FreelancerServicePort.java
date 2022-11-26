package com.nexum.backend.services.freelancer.interfaces;

import com.nexum.backend.dto.freelancer.FreelancerDTO;
import com.nexum.backend.dto.freelancer.formacao.FormacaoDTO;
import com.nexum.backend.dto.freelancer.formacao.request.FormacaoDTOCreateRequest;

import java.util.Collection;

public interface FreelancerServicePort {
    void create(FreelancerDTO freelancerDTO);

    Collection<FreelancerDTO> listAll();

    FreelancerDTO getById(Long id);
}
