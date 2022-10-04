package com.nexum.interfaces.controle.acesso;

import com.nexum.entities.controle.acesso.Role;
import com.nexum.enums.RoleName;

public interface RoleRepositoryPort {
    Role findRoleByName(RoleName roleName);
}
