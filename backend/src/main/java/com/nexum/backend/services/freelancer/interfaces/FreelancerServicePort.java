package com.nexum.backend.services.freelancer.interfaces;



import com.nexum.backend.dto.freelancer.FreelancerDTO;

import java.util.Collection;

public interface FreelancerServicePort {
    void create(FreelancerDTO freelancerDTO);

    Collection<FreelancerDTO> listAll();

    Integer countNumberFreelancers();

    FreelancerDTO getById(Long id);
}
