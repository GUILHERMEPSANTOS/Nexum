package com.nexum.entities;

import com.nexum.validation.DomainExceptionValidation;

public class User {
    private Long id_usuario;
    private String nome;
    private String email;
    private String senha;
    private String cpf;
    private String profissao;

    public User(String nome, String email, String senha, String userDTOSenha, String cpf, String profissao) {
    }

    public User(Long id_usuario, String nome, String email, String senha,
            String cpf, String profissao) throws DomainExceptionValidation {

        DomainExceptionValidation.when(id_usuario < 0, "Invalid ID value");
        this.id_usuario = id_usuario;
    }

    public User(String nome, String email, String senha, String cpf, String profissao)
            throws DomainExceptionValidation {
        validateDomain(nome, email, senha, cpf, profissao);
    }

    public void update(String nome, String email, String senha, String cpf, String profissao) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
        this.profissao = profissao;
    }

    public void validateDomain(String nome, String email, String senha,
            String cpf, String profissao) throws DomainExceptionValidation {

        DomainExceptionValidation.when(nome.length() < 3, "Invalid nome, too short, minimum 3 charecters");
        DomainExceptionValidation.when(nome.isBlank(), "Invalid nome, Name is required");
        DomainExceptionValidation.when(senha.isBlank(), "Invalid senha, Senha is required");
        DomainExceptionValidation.when(cpf.isBlank(), "Invalid cpf, CPF is required");
        DomainExceptionValidation.when(cpf.length() != 11, "Invalid cpf, should only contain 13 characters");
        DomainExceptionValidation.when(profissao.isBlank(), "Invalid profissão, profissão is required");

        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
        this.profissao = profissao;
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

    public String setNome(String nome) {
        this.nome = nome;
        return nome;
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

}
