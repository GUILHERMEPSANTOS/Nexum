package com.nexum.entities.controle.acesso;

import com.nexum.enums.RoleName;

public class Role {
    private Long id_role;

    private RoleName role;

    public Role() {
    }

    public Role(RoleName role) {
        this.role = role;
    }

    public Role(Long id_role, RoleName role) {
        this.id_role = id_role;
        this.role = role;
    }

    public Long getId_role() {
        return id_role;
    }

    public void setId_role(Long id_role) {
        this.id_role = id_role;
    }

    public RoleName getRole() {
        return role;
    }

    public void setRole(RoleName role) {
        this.role = role;
    }
}
