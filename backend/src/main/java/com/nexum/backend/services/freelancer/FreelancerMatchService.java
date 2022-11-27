package com.nexum.backend.services.freelancer;

import com.nexum.backend.domain.match.MatchEntity;
import com.nexum.backend.dto.freelancer.match.queries.GetMatchRequestsByFreelancerIdQuery;
import com.nexum.backend.mappers.freelancer.formacao.match.GetMatchRequestsByFreelancerIdQueryMapper;
import com.nexum.backend.services.freelancer.interfaces.FreelancerMatchServicePort;
import com.nexum.backend.repositories.freelancer.match.SpringFreelancerMatchRepository;
import com.nexum.backend.services.shared.match.interfaces.MatchServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.stream.Collectors;

public class FreelancerMatchService implements FreelancerMatchServicePort {

    private final SpringFreelancerMatchRepository springFreelancerMatchRepository;
    private final MatchServicePort matchServicePort;

    public FreelancerMatchService(
            SpringFreelancerMatchRepository springFreelancerMatchRepository,
            MatchServicePort matchServicePort
    ) {
        this.springFreelancerMatchRepository = springFreelancerMatchRepository;
        this.matchServicePort = matchServicePort;
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

    @Override
    public void acceptMatchRequest(Long id_freelancer, Long id_contratante) {
        Boolean matchAlreadyExists = matchServicePort.validateMatchRequestAlreadyExists(id_freelancer, id_contratante);

        if(!matchAlreadyExists){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Solicitação de Match não encontrada!");
        }

        springFreelancerMatchRepository.acceptMatchRequest(id_freelancer, id_contratante);
    }
}
