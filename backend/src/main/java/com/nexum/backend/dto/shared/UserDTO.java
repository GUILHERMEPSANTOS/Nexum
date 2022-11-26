package com.nexum.backend.mappers.shared.social.shared;

import antlr.actions.python.CodeLexer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nexum.backend.dto.shared.role.RoleDTO;

import java.util.Collection;

public class UserDTO {
    private Long id_user;
    private String nome;
    private String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String senha;
    private String celular;
    private Boolean isLogged;
    private Collection<RoleDTO> roles;

    public UserDTO() {
    }

    public UserDTO(Long id_user, String nome, String email, String celular) {
        this.id_user = id_user;
        this.nome = nome;
        this.email = email;
        this.celular = celular;
    }

    public UserDTO(Long id_user, String nome, String email, String celular, Boolean isLogged, Collection<RoleDTO> roles) {
        this.id_user = id_user;
        this.nome = nome;
        this.email = email;
        this.celular = celular;
        this.isLogged = isLogged;
        this.roles = roles;
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

    public Collection<RoleDTO> getRoles() {
        return roles;
    }
}
