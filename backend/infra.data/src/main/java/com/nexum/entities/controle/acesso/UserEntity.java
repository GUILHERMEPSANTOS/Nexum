package com.nexum.entities.controle.acesso;

import com.nexum.entities.User;
import com.nexum.validation.DomainExceptionValidation;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "tb_users")

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

    @Column(length = 45)
    @NotEmpty(message = "Senah is required")
    private String senha;

    @Column(length = 11, unique = true)
    @NotEmpty(message = "CPF is required")
    private String cpf;

    @Column
    @NotEmpty(message = "Profissao is required")
    private String profissao;

    public UserEntity() {
    }

    public UserEntity(User user) {
        this.nome = user.getNome();
        this.email = user.getEmail();
        this.senha = user.getSenha();
        this.cpf = user.getCpf();
        this.profissao = user.getProfissao();
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

    public User toUser() throws DomainExceptionValidation {
        return new User(this.id_usuario, this.nome, this.email, this.senha, this.cpf, this.profissao);
    }
}