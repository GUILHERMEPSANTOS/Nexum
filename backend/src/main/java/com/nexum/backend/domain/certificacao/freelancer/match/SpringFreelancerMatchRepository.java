package com.nexum.backend.domain.certificacao.freelancer.match;

import com.nexum.backend.domain.match.MatchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.Collection;

public interface SpringFreelancerMatchRepository extends JpaRepository<MatchEntity, Long> {

    @Query("select mt " +
           "from MatchEntity mt " +
           "where mt.freelancer.id_usuario = :id_freelancer")
    Collection<MatchEntity> getMatchsRequestByFreelancerId(@Param("id_freelancer") Long id_freelancer);
}