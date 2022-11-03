package com.nexum.backend.domain.controle.acesso;

import com.nexum.backend.enums.RoleName;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "tb_role")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id_role;
    @Column(name = "role_name")
    @Enumerated(EnumType.STRING)
    private RoleName roleName;

    public RoleEntity() {
    }

    public RoleEntity(RoleName roleName) {
        this.roleName = roleName;
    }

    public Long getId_role() {
        return id_role;
    }

    public void setId_role(Long id_role) {
        this.id_role = id_role;
    }

    public RoleName getRoleName() {
        return roleName;
    }

    public void setRoleName(RoleName roleName) {
        this.roleName = roleName;
    }
}
