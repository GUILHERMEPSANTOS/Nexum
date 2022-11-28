package com.nexum.backend.dto.freelancer.habilidade.request;

public class HabilidadeFreelancerCreateRequest {
    private Long id_freelancer;
    private Long id_habilidade;

    public HabilidadeFreelancerCreateRequest() {
    }

    public HabilidadeFreelancerCreateRequest(Long id_freelancer, Long id_habilidade) {
        this.id_freelancer = id_freelancer;
        this.id_habilidade = id_habilidade;
    }

    public Long getId_freelancer() {
        return id_freelancer;
    }

    public void setId_freelancer(Long id_freelancer) {
        this.id_freelancer = id_freelancer;
    }

    public Long getId_habilidade() {
        return id_habilidade;
    }

    public void setId_habilidade(Long id_habilidade) {
        this.id_habilidade = id_habilidade;
    }
}
