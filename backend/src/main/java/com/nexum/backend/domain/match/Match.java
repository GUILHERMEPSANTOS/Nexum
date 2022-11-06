package com.nexum.backend.domain.match;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.nexum.backend.domain.controle.acesso.ContratanteEntity;
import com.nexum.backend.domain.controle.acesso.FreelancerEntity;
import com.nexum.backend.dto.match.MatchDTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "tb_match")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id_match")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_match;

    @ManyToOne(fetch = FetchType.LAZY)
    private FreelancerEntity freelancer;

    @ManyToOne(fetch = FetchType.LAZY)
    private ContratanteEntity contratante;

    @Column(name = "status")
    private Boolean status;

    public Long getId_match() {
        return id_match;
    }

    public void setId_match(Long id_match) {
        this.id_match = id_match;
    }

    public Long getFreelancer() {
        return freelancer.getId_usuario();
    }

    public void setFreelancer(FreelancerEntity freelancer) {
        this.freelancer = freelancer;
    }

    public Long getContratante() {
        return contratante.getId_usuario();
    }

    public void setContratante(ContratanteEntity contratante) {
        this.contratante = contratante;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }


}
