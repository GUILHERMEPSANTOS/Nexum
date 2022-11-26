package com.nexum.backend.dto.freelancer.habilidade;

import com.nexum.backend.dto.freelancer.FreelancerDTO;

public class HabilidadeFreelancerDTO {
    private Long id_habilidade_freelancer;
    private FreelancerDTO freelancer;
    private HabilidadeDTO habilidade;
    private Boolean hasHabilidade;

    public HabilidadeFreelancerDTO() {
    }

    public HabilidadeFreelancerDTO(
            Long id_habilidade_freelancer,
            FreelancerDTO freelancer,
            HabilidadeDTO habilidade,
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

    public FreelancerDTO getFreelancer() {
        return freelancer;
    }

    public void setFreelancer(FreelancerDTO freelancer) {
        this.freelancer = freelancer;
    }

    public HabilidadeDTO getHabilidade() {
        return habilidade;
    }

    public void setHabilidade(HabilidadeDTO habilidade) {
        this.habilidade = habilidade;
    }

    public Boolean getHasHabilidade() {
        return hasHabilidade;
    }

    public void setHasHabilidade(Boolean hasHabilidade) {
        this.hasHabilidade = hasHabilidade;
    }
}
