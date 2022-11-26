package com.nexum.backend.mappers.shared.social.shared.social.request;

public class GetlistSocialNetworksByUserQuery {
    private Long id_social;
    private String nome;
    private String social_url;

    public GetlistSocialNetworksByUserQuery() {
    }

    public GetlistSocialNetworksByUserQuery(Long id_social, String nome, String social_url) {
        this.id_social = id_social;
        this.nome = nome;
        this.social_url = social_url;
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

    public String getSocial_url() {
        return social_url;
    }

    public void setSocial_url(String social_url) {
        this.social_url = social_url;
    }
}
