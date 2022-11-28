package com.nexum.backend.domain.habilidade;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.nexum.backend.domain.controle.acesso.FreelancerEntity;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Entity
@Table(name = "TB_USER_HABILIDADE")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id_habilidade_freelancer")
@Inheritance(strategy = InheritanceType.JOINED)
public class HabilidadeFreelancerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_habilidade_freelancer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private FreelancerEntity freelancer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_habilidade")
    private HabilidadeEntity habilidade;

    @Column
    private Boolean hasHabilidade;

    public HabilidadeFreelancerEntity() {
    }

    public HabilidadeFreelancerEntity(
            FreelancerEntity freelancer,
            HabilidadeEntity habilidade,
            Boolean hasHabilidade
    ) {
        this.freelancer = freelancer;
        this.habilidade = habilidade;
        this.hasHabilidade = hasHabilidade;
    }

    public HabilidadeFreelancerEntity(
            Long id_habilidade_freelancer,
            FreelancerEntity freelancer,
            HabilidadeEntity habilidade,
            Boolean hasHabilidade
    ) {
        this.id_habilidade_freelancer = id_habilidade_freelancer;
        this.freelancer = freelancer;
        this.habilidade = habilidade;
        this.hasHabilidade = hasHabilidade;
    }

    public Long getId_habilidade_freelancer() {
        return id_habilidade_freelancer;
    }

    public void setId_habilidade_freelancer(Long id_habilidade_freelancer) {
        this.id_habilidade_freelancer = id_habilidade_freelancer;
    }

    public FreelancerEntity getFreelancer() {
        return freelancer;
    }

    public void setFreelancer(FreelancerEntity freelancer) {
        this.freelancer = freelancer;
    }

    public HabilidadeEntity getHabilidade() {
        return habilidade;
    }

    public void setHabilidade(HabilidadeEntity habilidade) {
        this.habilidade = habilidade;
    }

    public Boolean getHasHabilidade() {
        return hasHabilidade;
    }

    public void setHasHabilidade(Boolean hasHabilidade) {
        this.hasHabilidade = hasHabilidade;
    }
}
