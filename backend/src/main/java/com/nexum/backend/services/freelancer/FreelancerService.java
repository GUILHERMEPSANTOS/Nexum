package com.nexum.backend.services.freelancer;

import com.nexum.backend.domain.controle.acesso.FreelancerEntity;
import com.nexum.backend.domain.controle.acesso.RoleEntity;

import com.nexum.backend.dto.freelancer.FreelancerDTO;
import com.nexum.backend.mappers.freelancer.FreelancerDTOMapper;

import com.nexum.backend.enums.RoleName;

import com.nexum.backend.repositories.shared.controle.acesso.SpringRoleRepository;
import com.nexum.backend.repositories.freelancer.SpringFreelancerRepository;

import com.nexum.backend.services.freelancer.interfaces.FreelancerServicePort;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

public class FreelancerService implements FreelancerServicePort {

    private final SpringFreelancerRepository springFreelancerRepository;
    private final SpringRoleRepository springRoleRepository;

    public FreelancerService(SpringFreelancerRepository springFreelancerRepository, SpringRoleRepository springRoleRepository) {
        this.springFreelancerRepository = springFreelancerRepository;
        this.springRoleRepository = springRoleRepository;
    }

    @Override
    public void create(FreelancerDTO freelancer) {
        FreelancerEntity user = new FreelancerEntity(freelancer.getNome(), freelancer.getEmail(), freelancer.getSenha(), freelancer.getCelular());

        RoleEntity role = springRoleRepository.findByRoleName(RoleName.ROLE_FREELANCER);

        user.getRoles().add(role);

        springFreelancerRepository.save(user);
    }

    @Override
    public Collection<FreelancerDTO> listAll() {
        return springFreelancerRepository.findAll().stream().map((freelancer -> FreelancerDTOMapper.toFreelancerDTO(freelancer))).collect(Collectors.toList());
    }

    @Override
    public Integer countNumberFreelancers() {
        return springFreelancerRepository.countNumberFreelancers();
    }

    @Override
    public FreelancerDTO getById(Long id) {

        Optional<FreelancerEntity> optionalFreelancer = springFreelancerRepository.findById(id);

        if (optionalFreelancer.isPresent()) {
            return FreelancerDTOMapper.toFreelancerDTO(optionalFreelancer.get());
        }

        return null;
    }
}
