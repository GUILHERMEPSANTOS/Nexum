package com.nexum.backend.domain.social;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "tb_social")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id_social")
public class SocialEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_social;
    @Column
    private String nome;
    @OneToMany(mappedBy = "social", cascade = CascadeType.ALL)
    private Collection<SocialUserEntity> socialUsers = new ArrayList<>();

    public SocialEntity() {
    }

    public SocialEntity(String nome) {
        this.nome = nome;
    }

    public SocialEntity(Long id_social, String nome) {
        this.id_social = id_social;
        this.nome = nome;
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

    public Collection<SocialUserEntity> getSocialUsers() {
        return socialUsers;
    }

    public void setSocialUsers(SocialUserEntity socialUser) {
        this.socialUsers.add(socialUser);
    }
}
