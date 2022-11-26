package com.nexum.backend.domain.certificacao.freelancer.experiencia;

import com.nexum.backend.domain.experiencia.ExperienciaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface SpringExperienciaRepository extends JpaRepository<ExperienciaEntity, Long> {
    @Query("select experiencia " +
            "from ExperienciaEntity experiencia " +
            "where experiencia.freelancer.id_usuario = :id_freelancer")
    Collection<ExperienciaEntity> findByFreelancerId(@Param("id_freelancer") Long id_freelancer);
}
