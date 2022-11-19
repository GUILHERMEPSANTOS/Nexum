package com.nexum.backend.repositories.freelancer.formacao;

import com.nexum.backend.domain.formacao.FormacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface SpringFormacaoRepository extends JpaRepository<FormacaoEntity, Long> {

    @Query("select formacao " +
           "from FormacaoEntity formacao " +
           "where formacao.freelancer.id_usuario = :id_freelancer")
    Collection<FormacaoEntity> findByFreelancerId(@Param("id_freelancer") Long id_freelancer);

}
