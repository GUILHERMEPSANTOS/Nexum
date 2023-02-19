package com.nexum.backend.repositories.shared.photo;

import com.nexum.backend.domain.controle.acesso.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringImageRepository extends JpaRepository<ImageEntity, Long> {
    ImageEntity findByUserId(@Param("userId") Long userId);
}
