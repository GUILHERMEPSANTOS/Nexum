package com.nexum.backend.domain.endereco;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nexum.backend.domain.controle.acesso.UserEntity;

import javax.persistence.*;

@Entity
@Table(name = "tb_endereco")
public class EnderecoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_endereco;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "estado")
    private String estado;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "id_usuario")
    private UserEntity user;

    public EnderecoEntity() {
    }

    public EnderecoEntity(String cidade, String estado) {
        this.cidade = cidade;
        this.estado = estado;
    }

    public EnderecoEntity(Long id_endereco, String cidade, String estado) {
        this.id_endereco = id_endereco;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Long getId_endereco() {
        return id_endereco;
    }

    public void setId_endereco(Long id_endereco) {
        this.id_endereco = id_endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
