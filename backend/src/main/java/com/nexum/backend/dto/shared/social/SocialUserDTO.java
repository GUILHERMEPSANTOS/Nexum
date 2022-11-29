package com.nexum.backend.dto.shared.social;

import com.nexum.backend.dto.shared.user.UserDTO;

public class SocialUserDTO {
    private Long id_social_user;
    private UserDTO user;
    private SocialDTO social;
    private String user_url;

    public SocialUserDTO(
            Long id_social_user,
            SocialDTO social,
            String user_url
    ) {
        this.id_social_user = id_social_user;
        this.social = social;
        this.user_url = user_url;
    }

    public Long getId_social_user() {
        return id_social_user;
    }

    public void setId_social_user(Long id_social_user) {
        this.id_social_user = id_social_user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public SocialDTO getSocial() {
        return social;
    }

    public void setSocial(SocialDTO social) {
        this.social = social;
    }

    public String getUser_url() {
        return user_url;
    }

    public void setUser_url(String user_url) {
        this.user_url = user_url;
    }

}
