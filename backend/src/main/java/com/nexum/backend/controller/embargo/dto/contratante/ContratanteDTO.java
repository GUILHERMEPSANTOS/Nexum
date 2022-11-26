package com.nexum.backend.controller.embargo.dto.contratante;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.nexum.backend.controller.embargo.dto.shared.endereco.EnderecoDTO;
import com.nexum.backend.controller.embargo.dto.shared.match.MatchDTO;
import com.nexum.backend.controller.embargo.dto.shared.social.SocialUserDTO;

import java.util.ArrayList;
import java.util.Collection;

public class ContratanteDTO {
    private Long id_user;
    private String nome;
    private String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String senha;
    private String celular;
    private Boolean isLogged;
    private EnderecoDTO endereco;
    private Collection<MatchDTO> matchs = new ArrayList<>();
    public Collection<SocialUserDTO> socialsUserDTO = new ArrayList<>();

    public ContratanteDTO() {
    }

    public ContratanteDTO(
            Long id_user,
            String nome,
            String email,
            String senha,
            String celular,
            Boolean isLogged,
            EnderecoDTO endereco,
            Collection<MatchDTO> matchs,
            Collection<SocialUserDTO> socialsUserDTO
    ) {
        this.id_user = id_user;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.celular = celular;
        this.isLogged = isLogged;
        this.endereco = endereco;
        this.matchs = matchs;
        this.socialsUserDTO = socialsUserDTO;
    }
    public ContratanteDTO(
            String nome,
            String email,
            String senha,
            String celular
    ) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.celular = celular;
    }

    public Long getId_user() {
        return id_user;
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

    public Collection<MatchDTO> getMatchs() {
        return matchs;
    }

    public Boolean getLogged() {
        return isLogged;
    }

    public void setLogged(Boolean logged) {
        isLogged = logged;
    }

    public EnderecoDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDTO endereco) {
        this.endereco = endereco;
    }

    public Collection<SocialUserDTO> getSocialsUserDTO() {
        return socialsUserDTO;
    }

    public void setSocialsUserDTO(SocialUserDTO socialsUserDTO) {
        this.socialsUserDTO.add(socialsUserDTO);
    }
}
