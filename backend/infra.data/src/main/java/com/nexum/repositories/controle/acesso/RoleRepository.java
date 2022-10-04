package com.nexum.repositories.controle.acesso;

import com.nexum.entities.controle.acesso.Role;
import com.nexum.entities.controle.acesso.RoleEntity;
import com.nexum.enums.RoleName;
import com.nexum.interfaces.controle.acesso.RoleRepositoryPort;
import com.nexum.repositories.controle.acesso.interfaces.SpringRoleRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class RoleRepository implements RoleRepositoryPort {
    private final SpringRoleRepository springRoleRepository;

    public RoleRepository(SpringRoleRepository springRoleRepository) {
        this.springRoleRepository = springRoleRepository;
    }

    @Override
    public Role findRoleByName(RoleName roleName){
        RoleEntity roleEntity = springRoleRepository.findByRoleName(roleName);

        return roleEntity.toRole();
    }
}
