package com.nexum.backend.mappers.shared.role;

import com.nexum.backend.domain.controle.acesso.RoleEntity;
import com.nexum.backend.dto.shared.role.RoleDTO;

import java.util.Collection;
import java.util.stream.Collectors;

public class RoleDTOMapper {
    public static RoleDTO toRoleDTO(RoleEntity roleEntity) {
        return new RoleDTO(
                roleEntity.getId_role(),
                roleEntity.getRoleName()
        );
    }

    public static Collection<RoleDTO> toCollectionRoleDTO(Collection<RoleEntity> roleEntities) {
        return roleEntities
                .stream()
                .map(RoleDTOMapper::toRoleDTO)
                .collect(Collectors.toList());
    }
}
