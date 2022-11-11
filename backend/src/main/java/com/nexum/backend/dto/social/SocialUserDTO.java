package com.nexum.backend.dto.social;

import com.nexum.backend.domain.controle.acesso.UserEntity;
import com.nexum.backend.domain.social.SocialEntity;
import com.nexum.backend.domain.social.SocialUserEntity;
import com.nexum.backend.dto.shared.UserDTO;

public class SocialUserDTO {
    private Long id_social_user;
    private UserDTO user;
    private SocialDTO social;
    private String user_url;

    public SocialUserDTO(SocialUserEntity socialUserEntity) {
        this.id_social_user = socialUserEntity.getId_social_user();
        this.user_url = socialUserEntity.getUser_url();
        toUserDTO(socialUserEntity.getUserEntity());
        toSocialDTO(socialUserEntity.getSocial());
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

    public void toUserDTO(UserEntity userEntity) {
        this.user = new UserDTO(userEntity.getNome(), userEntity.getEmail());
    }

    public void toSocialDTO(SocialEntity socialEntity) {
        this.social = new SocialDTO(socialEntity.getId_social(), socialEntity.getNome());
    }
}
