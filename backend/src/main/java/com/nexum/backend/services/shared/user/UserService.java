package com.nexum.backend.services.shared.user;

import com.nexum.backend.dto.shared.user.UserDTO;
import com.nexum.backend.dto.shared.user.request.UserSobreUpdateRequest;
import com.nexum.backend.repositories.shared.controle.acesso.SpringUserRepository;
import com.nexum.backend.services.freelancer.interfaces.HabilidadeServicePort;
import com.nexum.backend.services.shared.user.Interfaces.UserServicePort;
import org.springframework.scheduling.annotation.Async;

public class UserService implements UserServicePort {
    private final SpringUserRepository springUserRepository;

    public UserService(SpringUserRepository springUserRepository) {
        this.springUserRepository = springUserRepository;
    }

    @Override
    public Boolean existsById(Long id_user) {
        Boolean isValidUserId = springUserRepository.existsById(id_user);

        if (!isValidUserId) {
            throw new IllegalArgumentException("ID usuário inválido");
        }

        return isValidUserId;
    }

    @Override
    public void updateAboutUser(UserSobreUpdateRequest request) {
        this.existsById(request.getId_user());

        springUserRepository.updateAboutUser(request.getSobre(), request.getId_user());
    }
}
