package com.nexum.backend.dto.shared;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nexum.backend.domain.controle.acesso.ContratanteEntity;
import com.nexum.backend.domain.controle.acesso.FreelancerEntity;
import com.nexum.backend.domain.endereco.EnderecoEntity;
import com.nexum.backend.domain.habilidades.HabilidadeEntity;
import com.nexum.backend.domain.match.MatchEntity;
import com.nexum.backend.domain.social.SocialUserEntity;
import com.nexum.backend.dto.endereco.EnderecoDTO;
import com.nexum.backend.dto.habilidade.HabilidadeDTO;
import com.nexum.backend.dto.match.MatchDTO;
import com.nexum.backend.dto.social.SocialUserDTO;

import java.util.ArrayList;
import java.util.Collection;

public class UserDTO {
    private Long id_user;
    private String nome;
    private String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String senha;
    private String celular;
    private Boolean isLogged;

    public UserDTO() {
    }

    public UserDTO(Long id_user, String nome, String email, String celular) {
        this.id_user = id_user;
        this.nome = nome;
        this.email = email;
        this.celular = celular;
    }

    public UserDTO(Long id_user, String nome, String email, String celular, Boolean isLogged) {
        this.id_user = id_user;
        this.nome = nome;
        this.email = email;
        this.celular = celular;
        this.isLogged = isLogged;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
}
