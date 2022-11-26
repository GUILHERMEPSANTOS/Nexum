package com.nexum.backend.dto.shared.social.request;

public class SocialUserCreateRequest {
    private Long id_social;
    private String user_url;

    public SocialUserCreateRequest() {
    }

    public SocialUserCreateRequest(Long id_social, String user_url) {
        this.id_social = id_social;
        this.user_url = user_url;
    }

    public Long getId_social() {
        return id_social;
    }

    public void setId_social(Long id_social) {
        this.id_social = id_social;
    }

    public String getUser_url() {
        return user_url;
    }

    public void setUser_url(String user_url) {
        this.user_url = user_url;
    }
}
