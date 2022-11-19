package com.nexum.backend.dto.shared.match;

import com.nexum.backend.domain.match.MatchEntity;

public class MatchDTO {
    private Long id_match;
    private Long id_contratante;
    private Long id_freelancer;
    private Boolean status;

    public MatchDTO() {
    }

    public MatchDTO(
            Long id_contratante,
            Long id_freelancer,
            Long id_match,
            Boolean status
    ) {
        this.id_match = id_match;
        this.id_contratante = id_contratante;
        this.id_freelancer = id_freelancer;
        this.status = status;
    }

    public MatchDTO(MatchEntity match) {
        this.id_contratante = match.getContratante();
        this.id_freelancer = match.getFreelancer();
        this.id_match = match.getId_match();
        this.status = match.getStatus();
    }

    public Long getId_freelancer() {
        return id_freelancer;
    }

    public void setId_freelancer(Long id_freelancer) {
        this.id_freelancer = id_freelancer;
    }

    public Long getId_match() {
        return id_match;
    }

    public void setId_match(Long id_match) {
        this.id_match = id_match;
    }

    public Long getId_contratante() {
        return id_contratante;
    }

    public void setId_contratante(Long id_contratante) {
        this.id_contratante = id_contratante;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
