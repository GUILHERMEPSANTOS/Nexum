package com.nexum.backend.services.freelancer;

import com.nexum.backend.domain.match.MatchEntity;
import com.nexum.backend.controller.embargo.dto.contratante.ContratanteDTO;
import com.nexum.backend.mappers.contratante.ContratanteDTOMapper;
import com.nexum.backend.repositories.freelancer.certificacao.interfaces.FreelancerMatchServicePort;
import com.nexum.backend.repositories.freelancer.match.SpringFreelancerMatchRepository;

import java.util.Collection;
import java.util.stream.Collectors;

public class FreelancerMatchService implements FreelancerMatchServicePort {

    private final SpringFreelancerMatchRepository springFreelancerMatchRepository;

    public FreelancerMatchService(SpringFreelancerMatchRepository springFreelancerMatchRepository) {
        this.springFreelancerMatchRepository = springFreelancerMatchRepository;
    }

    @Override
    public Collection<ContratanteDTO> getMatchsRequestByFreelancerId(Long id_freelancer) {
        Collection<MatchEntity> matchEntities =
                springFreelancerMatchRepository.getMatchsRequestByFreelancerId(id_freelancer);

        return matchEntities
                .stream()
                .map(matchEntity -> ContratanteDTOMapper
                        .toContratanteDTO(matchEntity.getContratante()))
                .collect(Collectors.toList());
    }
}
