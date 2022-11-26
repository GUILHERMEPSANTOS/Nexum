package com.nexum.backend.dto.shared.role;

import com.nexum.backend.enums.RoleName;

public class RoleDTO {
    private Long id_role;
    private RoleName roleName;

    public RoleDTO(Long id_role, RoleName roleName) {
        this.id_role = id_role;
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

