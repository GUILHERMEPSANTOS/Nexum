package com.nexum.backend.repositories.freelancer;

import com.nexum.backend.domain.controle.acesso.FreelancerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SpringFreelancerRepository extends JpaRepository<FreelancerEntity, Long> {

    @Query("select count(*) from FreelancerEntity")
    Integer countNumberFreelancers();
}
