package com.nexum.backend.repositories.freelancer.match;

import com.nexum.backend.domain.match.MatchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


import java.util.Collection;

@Transactional
public interface SpringFreelancerMatchRepository extends JpaRepository<MatchEntity, Long> {

    @Query("select mt " +
            "from MatchEntity mt " +
            "where mt.freelancer.id_usuario = :id_freelancer " +
            "and mt.status = false")
    Collection<MatchEntity> getMatchsRequestByFreelancerId(@Param("id_freelancer") Long id_freelancer);

    @Modifying
    @Query("update " +
            "MatchEntity mt " +
            "set mt.status = true " +
            "where mt.freelancer.id_usuario = :id_freelancer " +
            "and mt.contratante.id_usuario = :id_contratante")
    void acceptMatchRequest(
            @Param("id_freelancer")  Long id_freelancer,
            @Param("id_contratante") Long id_contratante
    );
}
