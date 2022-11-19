package com.nexum.backend.dto.freelancer;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.nexum.backend.dto.freelancer.experiencia.ExperienciaDTO;
import com.nexum.backend.dto.freelancer.formacao.FormacaoDTO;
import com.nexum.backend.dto.shared.endereco.EnderecoDTO;
import com.nexum.backend.dto.shared.habilidade.HabilidadeDTO;
import com.nexum.backend.dto.shared.match.MatchDTO;
import com.nexum.backend.dto.shared.social.SocialUserDTO;

import java.util.ArrayList;
import java.util.Collection;

public class FreelancerDTO {
    private Long id_user;
    private String nome;
    private String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String senha;
    private String celular;
    private Boolean isLogged;
    private EnderecoDTO endereco;

    private Collection<ExperienciaDTO> experienciasDTO;

    private Collection<FormacaoDTO> formacoesDTO;
    private Collection<HabilidadeDTO> habilidades = new ArrayList<>();
    private Collection<MatchDTO> matchs = new ArrayList<>();
    public Collection<SocialUserDTO> socialsUserDTO = new ArrayList<>();
    public FreelancerDTO() {
    }
    public FreelancerDTO(
            Long id_user,
            String nome,
            String email,
            String senha,
            String celular,
            Boolean isLogged,
            EnderecoDTO endereco,
            Collection<HabilidadeDTO> habilidades,
            Collection<MatchDTO> matchs,
            Collection<SocialUserDTO> socialsUserDTO,
            Collection<ExperienciaDTO> experienciasDTO,
            Collection<FormacaoDTO> formacoesDTO
    ) {
        this.id_user = id_user;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.celular = celular;
        this.isLogged = isLogged;
        this.endereco = endereco;
        this.habilidades = habilidades;
        this.matchs = matchs;
        this.socialsUserDTO = socialsUserDTO;
        this.experienciasDTO = experienciasDTO;
        this.formacoesDTO = formacoesDTO;
    }

    public FreelancerDTO(
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

    public Collection<ExperienciaDTO> getExperienciasDTO() {
        return experienciasDTO;
    }

    public void setExperienciasDTO(ExperienciaDTO experienciaDTO) {
        this.experienciasDTO.add(experienciaDTO);
    }

    public Collection<FormacaoDTO> getFormacoesDTO() {
        return formacoesDTO;
    }

    public void setFormacoesDTO(FormacaoDTO formacaoDTO) {
        this.formacoesDTO.add(formacaoDTO);
    }
}
