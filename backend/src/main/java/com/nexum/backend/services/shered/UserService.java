package com.nexum.backend.services.shered;

import com.nexum.backend.repositories.controle.acesso.SpringUserRepository;
import com.nexum.backend.services.shered.interfaces.UserServicePort;

public class UserService implements UserServicePort {

    private SpringUserRepository springUserRepository;

    public UserService(SpringUserRepository springUserRepository) {
        this.springUserRepository = springUserRepository;
    }

    @Override
    public void loadUserInformation(Long idUser) {
        springUserRepository.findById(idUser);
    }
}
