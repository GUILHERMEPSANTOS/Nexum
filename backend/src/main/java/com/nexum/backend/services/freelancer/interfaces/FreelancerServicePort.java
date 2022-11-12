package com.nexum.backend.services.freelancer.interfaces;

import com.nexum.backend.dto.freelancer.FreelancerDTO;
import com.nexum.backend.dto.shared.UserDTO;
import com.nexum.backend.repositories.freelancer.SpringFreelancerRepository;

import java.util.Collection;

public interface FreelancerServicePort {
    Collection<FreelancerDTO> listAll();
    FreelancerDTO getFreelancerById(Long id);
}
