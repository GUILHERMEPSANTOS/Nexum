package com.nexum.backend.dto.shared;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nexum.backend.domain.controle.acesso.ContratanteEntity;
import com.nexum.backend.domain.controle.acesso.FreelancerEntity;
import com.nexum.backend.domain.endereco.EnderecoEntity;
import com.nexum.backend.domain.habilidades.HabilidadeEntity;
import com.nexum.backend.domain.match.Match;
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
    private EnderecoDTO endereco;
    private Collection<HabilidadeDTO> habilidades = new ArrayList<>();
    private Collection<MatchDTO> matchs = new ArrayList<>();
    public Collection<SocialUserDTO> socialsUserDTO = new ArrayList<>();
    public Collection<HabilidadeDTO> getHabilidades() {
        return habilidades;
    }

    public UserDTO() {
    }
    public UserDTO(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public UserDTO(String nome, String email, String senha, String cpf, String celular) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.celular = celular;
    }


    public UserDTO(FreelancerEntity user) {
        this.id_user = user.getId_usuario();
        this.nome = user.getNome();
        this.email = user.getEmail();
        this.senha = user.getSenha();
        this.celular = user.getCelular();
        this.isLogged = user.getLogged();
        toEnderecoDTO(user.getEndereco());
        toMatchDTO(user.getMatch());
        toHabilidadeDTO(user.getHabilidades());
        toSocialUserDTO(user.getSocialUsers());
    }

    public UserDTO(ContratanteEntity user) {
        this.id_user = user.getId_usuario();
        this.nome = user.getNome();
        this.email = user.getEmail();
        this.senha = user.getSenha();
        this.celular = user.getCelular();
        this.isLogged = user.getLogged();
        toEnderecoDTO(user.getEndereco());
        toMatchDTO(user.getMatch());
        toHabilidadeDTO(user.getHabilidades());
        toSocialUserDTO(user.getSocialUsers());
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

    public void setHabilidades(HabilidadeDTO habilidade) {
        this.habilidades.add(habilidade);
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

    private void toMatchDTO(Collection<Match> matchs) {
        matchs.forEach((match) -> this.matchs.add(new MatchDTO(match)));
    }

    private void toHabilidadeDTO(Collection<HabilidadeEntity> habilidadeEntities) {
        habilidadeEntities.forEach((habilidadeEntity)
                -> this.habilidades.add(new HabilidadeDTO(habilidadeEntity)));
    }

    private void toEnderecoDTO(EnderecoEntity enderecoEntity) {
        this.endereco = new EnderecoDTO(enderecoEntity);
    }

    private void toSocialUserDTO(Collection<SocialUserEntity> socialsUserEntity) {
        socialsUserEntity.forEach((socialUserEntity) ->
                this.socialsUserDTO.add(new SocialUserDTO(socialUserEntity)));
    }

}
