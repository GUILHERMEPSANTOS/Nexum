package com.nexum.backend.dto.freelancer.match;

import com.nexum.backend.dto.freelancer.habilidade.HabilidadeFreelancerDTO;
import com.nexum.backend.dto.shared.endereco.EnderecoDTO;
import com.nexum.backend.dto.shared.match.MatchDTO;
import com.nexum.backend.dto.shared.social.SocialUserDTO;

import java.util.ArrayList;
import java.util.Collection;

public class GetMatchRequestsByFreelancerIdQuery {
    private Long id_user;
    private String nome;
    private String email;
    private String celular;
    private EnderecoDTO endereco;
    private String sobre;
    public Collection<SocialUserDTO> socialsUserDTO = new ArrayList<>();


    public GetMatchRequestsByFreelancerIdQuery() {
    }

    public GetMatchRequestsByFreelancerIdQuery(
            Long id_user,
            String nome,
            String email,
            String celular,
            EnderecoDTO endereco,
            String sobre,
            Collection<SocialUserDTO> socialsUserDTO
    ) {
        this.id_user = id_user;
        this.nome = nome;
        this.email = email;
        this.celular = celular;
        this.endereco = endereco;
        this.sobre = sobre;
        this.socialsUserDTO = socialsUserDTO;
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

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public EnderecoDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDTO endereco) {
        this.endereco = endereco;
    }

    public String getSobre() {
        return sobre;
    }

    public void setSobre(String sobre) {
        this.sobre = sobre;
    }

    public Collection<SocialUserDTO> getSocialsUserDTO() {
        return socialsUserDTO;
    }

    public void setSocialsUserDTO(Collection<SocialUserDTO> socialsUserDTO) {
        this.socialsUserDTO = socialsUserDTO;
    }
}
