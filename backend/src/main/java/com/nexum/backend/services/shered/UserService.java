package com.nexum.backend.services.shered;

import com.nexum.backend.domain.controle.acesso.UserEntity;
import com.nexum.backend.domain.controle.acesso.interfaces.UserStrategy;
import com.nexum.backend.dto.shared.UserDTO;
import com.nexum.backend.repositories.controle.acesso.SpringUserRepository;
import com.nexum.backend.services.shered.interfaces.UserServicePort;

import java.util.Optional;

public class UserService implements UserServicePort {
    private SpringUserRepository springUserRepository;

    public UserService(SpringUserRepository springUserRepository) {
        this.springUserRepository = springUserRepository;
    }

    @Override
    public UserDTO loadUserInformation(Long idUser) {
        Optional<UserEntity> userEntity = springUserRepository.findById(idUser);

        if (userEntity.isPresent()) {
            return ((UserStrategy) userEntity.get()).toUserDTO();
        }

        return null;
    }
}
