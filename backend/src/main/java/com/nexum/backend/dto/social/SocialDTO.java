package com.nexum.backend.dto.social;

import com.nexum.backend.domain.social.SocialEntity;

public class SocialDTO {
    private Long id_social;
    private String nome;

    public SocialDTO(Long id_social, String nome) {
        this.id_social = id_social;
        this.nome = nome;
    }

    public SocialDTO(SocialEntity socialEntity) {
        this.id_social = socialEntity.getId_social();
        this.nome = socialEntity.getNome();
    }

    public Long getId_social() {
        return id_social;
    }

    public void setId_social(Long id_social) {
        this.id_social = id_social;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
