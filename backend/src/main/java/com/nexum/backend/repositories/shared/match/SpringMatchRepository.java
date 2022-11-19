package com.nexum.backend.repositories.shared.match;

import com.nexum.backend.domain.match.MatchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SpringMatchRepository extends JpaRepository<MatchEntity, Long> {
    @Query("select case when (count(match) > 0) " +
                        "then true " +
                        "else false " +
                   "end  \n" +
           "from MatchEntity match " +
           "where match.freelancer.id_usuario = :id_freelancer " +
                "and match.contratante.id_usuario = :id_contratante")
    Boolean matchRequestAlreadyExists(
            @Param("id_freelancer") Long id_freelancer,
            @Param("id_contratante") Long id_contratante
    );
}
