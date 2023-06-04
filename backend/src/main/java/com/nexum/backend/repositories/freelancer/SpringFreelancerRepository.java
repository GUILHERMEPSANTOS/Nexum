package com.nexum.backend.repositories.freelancer;

import com.nexum.backend.domain.controle.acesso.FreelancerEntity;
import com.nexum.backend.domain.controle.acesso.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SpringFreelancerRepository extends JpaRepository<FreelancerEntity, Long> {
    @Query("select count(*) from FreelancerEntity")
    Integer countNumberFreelancers();

    @Query("SELECT DISTINCT freelancer FROM FreelancerEntity freelancer LEFT JOIN FETCH freelancer.image")
    List<FreelancerEntity> findAllUsersWithImages();


}
