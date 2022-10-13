package com.nexum.backend.domain.controle.acesso;

import com.nexum.backend.dto.controle.acesso.UserDTO;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "tb_users")
@Inheritance(
        strategy = InheritanceType.JOINED
)
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
    @NotEmpty(message = "Senah is required")
    private String senha;

    @Column(length = 11, unique = true)
    @NotEmpty(message = "CPF is required")
    private String cpf;

    @Column
    @NotEmpty(message = "Profissao is required")
    private String profissao;


    @Column
    private Boolean isLogged = false;

    @ManyToMany
    @JoinTable(name = "TB_USERS_ROLES",
            joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_role")
    )
    private Collection<RoleEntity> roles = new ArrayList<>();

    public UserEntity() {
    }

    public UserEntity(UserDTO userDTO) {
        this.nome = userDTO.getNome();
        this.email = userDTO.getEmail();
        this.senha = userDTO.getSenha();
        this.cpf = userDTO.getCpf();
        this.profissao = userDTO.getProfissao();

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
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

}
