package com.nexum.backend.repositories.freelancer.certificacao;

import com.nexum.backend.domain.certificacao.CertificacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface SpringCertificacaoRepository extends JpaRepository<CertificacaoEntity, Long> {
    @Query("select certificacao " +
            "from CertificacaoEntity certificacao " +
            "where certificacao.freelancer.id_usuario = :id_freelancer")
    Collection<CertificacaoEntity> findByFreelancerId(@Param("id_freelancer") Long id_freelancer);
}
