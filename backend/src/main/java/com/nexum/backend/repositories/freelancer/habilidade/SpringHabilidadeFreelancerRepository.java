package com.nexum.backend.repositories.freelancer.habilidade;

import com.nexum.backend.domain.habilidade.HabilidadeFreelancerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface SpringHabilidadeFreelancerRepository extends JpaRepository<HabilidadeFreelancerEntity, Long> {

    @Query("select h " +
           "from HabilidadeFreelancerEntity h " +
           "where h.freelancer.id_usuario = :id_freelancer")
    Collection<HabilidadeFreelancerEntity> listByFreelancerID(@Param("id_freelancer") Long id_freelancer);
}
