package com.nexum.backend.dto.freelancer.habilidade;

import com.nexum.backend.dto.freelancer.FreelancerDTO;

public class HabilidadeFreelancerDTO {
    private Long id_habilidade_freelancer;
    private Long id_freelancer;
    private Long id_habilidade;
    private String nome;
    private Boolean hasHabilidade;

    public HabilidadeFreelancerDTO() {
    }

    public HabilidadeFreelancerDTO(
            Long id_habilidade_freelancer,
            Long id_freelancer,
            Long id_habilidade,
            Boolean hasHabilidade,
            String nome
    ) {
        this.id_habilidade_freelancer = id_habilidade_freelancer;
        this.id_freelancer = id_freelancer;
        this.id_habilidade = id_habilidade;
        this.hasHabilidade = hasHabilidade;
        this.nome = nome;
    }

    public Long getId_habilidade_freelancer() {
        return id_habilidade_freelancer;
    }

    public void setId_habilidade_freelancer(Long id_habilidade_freelancer) {
        this.id_habilidade_freelancer = id_habilidade_freelancer;
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

    public Boolean getHasHabilidade() {
        return hasHabilidade;
    }

    public void setHasHabilidade(Boolean hasHabilidade) {
        this.hasHabilidade = hasHabilidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
