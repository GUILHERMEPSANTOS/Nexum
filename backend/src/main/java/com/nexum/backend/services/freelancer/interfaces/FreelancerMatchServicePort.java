package com.nexum.backend.services.freelancer.interfaces;

import com.nexum.backend.dto.freelancer.match.queries.GetMatchRequestsByFreelancerIdQuery;

import java.util.Collection;

public interface FreelancerMatchServicePort {
    Collection<GetMatchRequestsByFreelancerIdQuery> getMatchsRequestByFreelancerId(Long id_freelancer);
}
