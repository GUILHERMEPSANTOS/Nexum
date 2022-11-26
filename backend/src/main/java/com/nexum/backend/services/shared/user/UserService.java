package com.nexum.backend.services.shared.user;

import com.nexum.backend.repositories.shared.controle.acesso.SpringUserRepository;
import com.nexum.backend.services.freelancer.interfaces.HabilidadeServicePort;
import com.nexum.backend.services.shared.user.Interfaces.UserServicePort;

public class UserService implements UserServicePort {
    private final SpringUserRepository springUserRepository;
    private final HabilidadeServicePort habilidadeServicePort;

    public UserService(SpringUserRepository springUserRepository, HabilidadeServicePort habilidadeServicePort) {
        this.springUserRepository = springUserRepository;
        this.habilidadeServicePort = habilidadeServicePort;
    }

    @Override
    public Boolean existsById(Long id_user) {
        Boolean isValidUserId = springUserRepository.existsById(id_user);

        if (!isValidUserId) {
            throw new IllegalArgumentException("ID usuário inválido");
        }

        return isValidUserId;
    }
}
