package com.nexum.backend.repositories.freelancer.certificacao.interfaces;



import com.nexum.backend.controller.embargo.dto.freelancer.FreelancerDTO;

import java.util.Collection;

public interface FreelancerServicePort {
    void create(FreelancerDTO freelancerDTO);

    Collection<FreelancerDTO> listAll();

    FreelancerDTO getById(Long id);
}
