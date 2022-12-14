package com.nexum.backend.repositories.freelancer;

import com.nexum.backend.domain.controle.acesso.FreelancerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SpringFreelancerRepository extends JpaRepository<FreelancerEntity, Long> {

    //    @Transactional
//    @Modifying
//    @Query("update FreelancerEntity f " +
//                "set f.endereco.cidade = :cidade, " +
//                    "f.endereco.estado = :estado " +
//            "where f.id_usuario = :id_freelancer")
//    void updateAddressByFreelancerId(
//            @Param("estado") String estado,
//            @Param("cidade") String cidade,
//            @Param("id_freelancer") Long id_freelancer
//    );

    @Query("select count(*) from FreelancerEntity")
    Integer countNumberFreelancers();
}
