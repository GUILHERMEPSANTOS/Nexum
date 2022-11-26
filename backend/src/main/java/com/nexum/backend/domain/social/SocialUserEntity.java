package com.nexum.backend.domain.social;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.nexum.backend.domain.controle.acesso.UserEntity;

import javax.persistence.*;

@Entity
@Table(name = "tb_social_user")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id_social_user")
    public class SocialUserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_social_user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_social")
    private SocialEntity social;

    @Column
    private String user_url;

    public SocialUserEntity() {
    }

    public SocialUserEntity(UserEntity user, String user_url) {
        this.user = user;
        this.user_url = user_url;
    }

    public SocialUserEntity(UserEntity user, SocialEntity social, String user_url) {
        this.user = user;
        this.social = social;
        this.user_url = user_url;
    }

    public Long getId_social_user() {
        return id_social_user;
    }

    public void setId_social_user(Long id_social_user) {
        this.id_social_user = id_social_user;
    }

    public UserEntity getUserEntity() {
        return user;
    }

    public void setUserEntity(UserEntity userEntity) {
        userEntity.setSocialUsers(this);
        this.user = userEntity;
    }

    public SocialEntity getSocial() {
        return social;
    }

    public void setSocial(SocialEntity social) {
        social.setSocialUsers(this);
        this.social = social;
    }

    public String getUser_url() {
        return user_url;
    }

    public void setUser_url(String user_url) {
        this.user_url = user_url;
    }
}
