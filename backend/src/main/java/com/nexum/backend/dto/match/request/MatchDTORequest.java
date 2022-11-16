package com.nexum.backend.dto.match.request;

import javax.validation.constraints.NotNull;

public class MatchDTORequest {
    @NotNull
    private Long id_contratante;
    @NotNull
    private Long id_freelancer;

    public MatchDTORequest() {
    }

    public MatchDTORequest(Long id_contratante, Long id_freelancer) {
        this.id_contratante = id_contratante;
        this.id_freelancer = id_freelancer;
    }

    public Long getId_freelancer() {
        return id_freelancer;
    }

    public void setId_freelancer(Long id_freelancer) {
        this.id_freelancer = id_freelancer;
    }

    public Long getId_contratante() {
        return id_contratante;
    }

    public void setId_contratante(Long id_contratante) {
        this.id_contratante = id_contratante;
    }
}
