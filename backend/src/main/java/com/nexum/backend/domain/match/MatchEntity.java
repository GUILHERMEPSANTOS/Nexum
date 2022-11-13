package com.nexum.backend.domain.match;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.nexum.backend.domain.controle.acesso.ContratanteEntity;
import com.nexum.backend.domain.controle.acesso.FreelancerEntity;

import javax.persistence.*;


@Entity
@Table(name = "tb_match")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id_match")
public class MatchEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_match;

    @ManyToOne(fetch = FetchType.LAZY)
    private FreelancerEntity freelancer;

    @ManyToOne(fetch = FetchType.LAZY)
    private ContratanteEntity contratante;

    @Column(name = "status")
    private Boolean status;

    public MatchEntity() {
        this.status = false;
    }

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
        freelancer.setMatch(this);
        this.freelancer = freelancer;
    }

    public Long getContratante() {
        return contratante.getId_usuario();
    }

    public void setContratante(ContratanteEntity contratante) {
        contratante.setMatch(this);
        this.contratante = contratante;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
