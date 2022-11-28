package com.nexum.backend.repositories.freelancer.habilidade;

import com.nexum.backend.domain.habilidade.HabilidadeFreelancerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.TransactionScoped;
import javax.transaction.Transactional;
import java.util.Collection;

@Transactional
public interface SpringHabilidadeFreelancerRepository extends JpaRepository<HabilidadeFreelancerEntity, Long> {

    @Query("select h " +
           "from HabilidadeFreelancerEntity h " +
           "where h.freelancer.id_usuario = :id_freelancer")
    Collection<HabilidadeFreelancerEntity> listByFreelancerID(@Param("id_freelancer") Long id_freelancer);


    @Query("select (count(hf) > 0) " +
           "from HabilidadeFreelancerEntity hf " +
           "where hf.freelancer.id_usuario = :id_freelancer " +
                "and hf.habilidade.id_habilidade = :id_habilidade")
    Boolean validateSkillAlreadyRegisteredToUser(
            @Param("id_freelancer") Long id_freelancer,
            @Param("id_habilidade") Long id_habilidade
    );

    @Modifying
    @Query("update " +
                "HabilidadeFreelancerEntity hf " +
           "set hf.hasHabilidade = case " +
                                        "when (select hf.hasHabilidade " +
                                             "from HabilidadeFreelancerEntity hf " +
                                             "where hf.freelancer.id_usuario = :id_freelancer " +
                                                "and hf.habilidade.id_habilidade = :id_habilidade) = true " +
                                        "then false " +
                                        "else true " +
                                  "end " +
            "where hf.freelancer.id_usuario = :id_freelancer" +
            " and hf.habilidade.id_habilidade = :id_habilidade"
    )
    void updateHabilidadeFreelancer(
            @Param("id_freelancer") Long id_freelancer,
            @Param("id_habilidade") Long id_habilidade
    );
}
