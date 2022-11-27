package com.nexum.backend.services.freelancer;

import com.nexum.backend.domain.match.MatchEntity;
import com.nexum.backend.dto.freelancer.match.queries.GetMatchRequestsByFreelancerIdQuery;
import com.nexum.backend.mappers.freelancer.formacao.match.GetMatchRequestsByFreelancerIdQueryMapper;
import com.nexum.backend.services.freelancer.interfaces.FreelancerMatchServicePort;
import com.nexum.backend.repositories.freelancer.match.SpringFreelancerMatchRepository;

import java.util.Collection;
import java.util.stream.Collectors;

public class FreelancerMatchService implements FreelancerMatchServicePort {

    private final SpringFreelancerMatchRepository springFreelancerMatchRepository;

    public FreelancerMatchService(SpringFreelancerMatchRepository springFreelancerMatchRepository) {
        this.springFreelancerMatchRepository = springFreelancerMatchRepository;
    }

    @Override
    public Collection<GetMatchRequestsByFreelancerIdQuery> getMatchsRequestByFreelancerId(Long id_freelancer) {
        Collection<MatchEntity> matchEntities =
                springFreelancerMatchRepository.getMatchsRequestByFreelancerId(id_freelancer);

        return matchEntities
                .stream()
                .map(matchEntity -> GetMatchRequestsByFreelancerIdQueryMapper.toGetMatchRequestsByFreelancerIdQuery(
                        matchEntity.getContratante()
                ))
                .collect(Collectors.toList());
    }
}
