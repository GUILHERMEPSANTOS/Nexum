package com.nexum.repositories.controle.acesso;

import com.nexum.entities.controle.acesso.RoleEntity;
import com.nexum.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringRoleRepository extends JpaRepository<RoleEntity, Long> {
    RoleEntity findByRoleName(RoleName roleName);
}
