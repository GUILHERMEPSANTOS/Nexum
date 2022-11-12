package com.nexum.backend.domain.controle.acesso;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.nexum.backend.domain.endereco.EnderecoEntity;
import com.nexum.backend.domain.habilidades.HabilidadeEntity;
import com.nexum.backend.domain.social.SocialUserEntity;
import com.nexum.backend.dto.shared.UserDTO;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "tb_users")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id_usuario")
@Inheritance(strategy = InheritanceType.JOINED)
public class UserEntity {
    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;
    @Column(length = 45)
    @NotEmpty(message = "Name is required")
    private String nome;
    @Column(length = 80)
    @NotEmpty(message = "Email is required")
    @Email(message = "Email is invalid")
    private String email;
    @Column(length = 100)
    @NotEmpty(message = "Senha is required")
    private String senha;
    @Column
    @NotEmpty(message = "celular is required")
    private String celular;

    @Column(length = 500)
    private String sobre;

    @Column
    private Boolean isLogged = false;

    @ManyToMany
    @JoinTable(
            name = "TB_USERS_ROLES",
            joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_role")
    )
    private Collection<RoleEntity> roles = new ArrayList<>();
    @OneToMany(
            mappedBy = "user",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Collection<SocialUserEntity> socialUsers = new ArrayList<>();
    @OneToOne(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private EnderecoEntity endereco;

    @ManyToMany
    @JoinTable(name = "TB_USERS_HABILIDADES",
            joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_habilidade")
    )
    private Collection<HabilidadeEntity> habilidades = new ArrayList<>();


    public UserEntity() {
    }
    public UserEntity(
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

    public UserEntity(UserDTO userDTO) {
        this.nome = userDTO.getNome();
        this.email = userDTO.getEmail();
        this.senha = userDTO.getSenha();
        this.celular = userDTO.getCelular();
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
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

    public void setCelular(String profissao) {
        this.celular = celular;
    }

    public Collection<RoleEntity> getRoles() {
        return roles;
    }

    public Boolean getLogged() {
        return isLogged;
    }

    public void setLogged(Boolean logged) {
        isLogged = logged;
    }

    public void setRoles(RoleEntity role) {
        this.roles.add(role);
    }

    public void setRoles(Collection<RoleEntity> roles) {
        this.roles = roles;
    }

    public String getSobre() {
        return sobre;
    }

    public void setSobre(String sobre) {
        this.sobre = sobre;
    }

    public Collection<SocialUserEntity> getSocialUsers() {
        return socialUsers;
    }

    public void setSocialUsers(SocialUserEntity socialUser) {
        this.socialUsers.add(socialUser);
    }

    public EnderecoEntity getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoEntity endereco) {
        this.endereco = endereco;
    }

    public Collection<HabilidadeEntity> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(HabilidadeEntity habilidade) {
        this.habilidades.add(habilidade);
    }

}
