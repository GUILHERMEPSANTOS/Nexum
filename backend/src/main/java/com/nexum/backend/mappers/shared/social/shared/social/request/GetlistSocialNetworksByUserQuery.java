package com.nexum.backend.dto.shared.social.request;

public class GetlistSocialNetworksByUserQuery {
    private Long id_user;
    private String nome;
    private String social_url;

    public GetlistSocialNetworksByUserQuery() {
    }

    public GetlistSocialNetworksByUserQuery(Long id_user, String nome, String social_url) {
        this.id_user = id_user;
        this.nome = nome;
        this.social_url = social_url;
    }

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
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
