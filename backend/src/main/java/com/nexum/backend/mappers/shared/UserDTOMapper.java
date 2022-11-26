package com.nexum.backend.mappers.shared;

import com.nexum.backend.domain.controle.acesso.UserEntity;
import com.nexum.backend.controller.embargo.dto.shared.UserDTO;

public class UserDTOMapper {
    public static UserDTO toUserDTOMapper(UserEntity userEntity) {
        return new UserDTO(
                userEntity.getId_usuario(),
                userEntity.getNome(),
                userEntity.getEmail(),
                userEntity.getCelular(),
                userEntity.getLogged()
        );
    }
}
