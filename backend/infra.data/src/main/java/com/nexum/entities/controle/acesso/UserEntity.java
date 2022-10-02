package com.nexum.entities.controle.acesso;

import com.nexum.validation.DomainExceptionValidation;

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

    @ManyToMany
    @JoinTable(name = "TB_USERS_ROLES",
            joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_role")
    )
    private Collection<RoleEntity> roles = new ArrayList<>();

    public UserEntity() {

    }

    public UserEntity(User user) {
        this.nome = user.getNome();
        this.email = user.getEmail();
        this.senha = user.getSenha();
        this.cpf = user.getCpf();
        this.profissao = user.getProfissao();
    }

    public UserEntity(Long id_usuario, String nome, String email, String senha,
                      String cpf, String profissao, Collection<RoleEntity> roles) {
        this.id_usuario = id_usuario;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
        this.profissao = profissao;
        this.roles = roles;
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

    public void setRoles(RoleEntity role) {
        this.roles.add(role);
    }

    public User toUser() throws DomainExceptionValidation {
        return new User(this.id_usuario, this.nome, this.email, this.senha, this.cpf, this.profissao);
    }

    public User toUserWithRole() throws DomainExceptionValidation {

        Collection<Role> rolesDomain = new ArrayList<>();

        this.roles.stream().forEach(roleEntity -> rolesDomain.add(
                new Role(roleEntity.getId_role(), roleEntity.getRoleName())));

        return new User(this.id_usuario, this.nome, this.email, this.senha, this.cpf, this.profissao, rolesDomain);
    }

}
