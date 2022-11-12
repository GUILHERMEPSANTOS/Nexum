package com.nexum.backend.services.freelancer;

import com.nexum.backend.domain.controle.acesso.FreelancerEntity;
import com.nexum.backend.dto.freelancer.FreelancerDTO;
import com.nexum.backend.dto.mappers.freelancer.FreelancerDTOMapper;

import com.nexum.backend.repositories.freelancer.SpringFreelancerRepository;
import com.nexum.backend.services.freelancer.interfaces.FreelancerServicePort;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

public class FreelancerService implements FreelancerServicePort {
    private final SpringFreelancerRepository springFreelancerRepository;

    public FreelancerService(SpringFreelancerRepository springFreelancerRepository) {
        this.springFreelancerRepository = springFreelancerRepository;
    }

    @Override
    public Collection<FreelancerDTO> listAll() {
        return springFreelancerRepository
                .findAll()
                .stream()
                .map((freelancer -> FreelancerDTOMapper.toFreelancerDTO(freelancer)))
                .collect(Collectors.toList());
    }

    @Override
    public FreelancerDTO getFreelancerById(Long id) {
        // TODO: 12/11/2022
//        Optional<FreelancerEntity> optionalFreelancer = springFreelancerRepository.findById(id);
//        https://www.toptal.com/java/spring-boot-rest-api-error-handling
//        if(optionalFreelancer.get()) {
//
//        }
        return null;
    }
}
