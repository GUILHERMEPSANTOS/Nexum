package com.nexum.backend.repositories.shared.controle.acesso;

import com.nexum.backend.domain.controle.acesso.RoleEntity;
import com.nexum.backend.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringRoleRepository extends JpaRepository<RoleEntity, Long> {
    RoleEntity findByRoleName(RoleName roleName);
}
