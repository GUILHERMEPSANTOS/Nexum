package com.nexum.backend.dto.controle.acesso;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nexum.backend.domain.controle.acesso.UserEntity;

public class UserDTO {
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long id_userDTO;
    private String nome;

    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String senha;

    private String celular;

    private Boolean isLogged;

    public Boolean getLogged() {
        return isLogged;
    }

    public void setLogged(Boolean logged) {
        isLogged = logged;
    }

    public UserDTO() {
    }

    public UserDTO(String nome, String email, String senha, String cpf, String celular) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.celular = celular;
    }


    public UserDTO(UserEntity user) {
        this.nome = user.getNome();
        this.email = user.getEmail();
        this.senha = user.getSenha();
        this.celular = user.getCelular();
        this.isLogged = user.getLogged();
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
