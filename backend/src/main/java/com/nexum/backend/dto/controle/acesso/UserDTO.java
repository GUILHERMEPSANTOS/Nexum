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

    private String cpf;

    private String profissao;

    public UserDTO() {
    }

    public UserDTO(String nome, String email, String senha, String cpf, String profissao) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
        this.profissao = profissao;
    }


    public UserDTO(UserEntity user) {
        this.nome = user.getNome();
        this.email = user.getEmail();
        this.senha = user.getSenha();
        this.cpf = user.getCpf();
        this.profissao = user.getProfissao();
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
}
