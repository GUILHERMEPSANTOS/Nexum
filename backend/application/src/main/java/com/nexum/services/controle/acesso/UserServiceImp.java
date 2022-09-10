package com.nexum.services.controle.acesso;

import com.nexum.dtos.controle.acesso.UserDTO;
import com.nexum.entities.User;
import com.nexum.interfaces.UserRepositoryPort;
import com.nexum.interfaces.controle.acesso.UserServicePort;
import com.nexum.validation.DomainExceptionValidation;

import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImp implements UserServicePort {
    private final UserRepositoryPort userRepositoryPort;

    public UserServiceImp(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public void create(UserDTO userDTO) throws DomainExceptionValidation {
        User user = new User(userDTO.getNome(), userDTO.getEmail(),
                userDTO.getSenha(), userDTO.getCpf(), userDTO.getProfissao());

        userRepositoryPort.create(user);
    }

    @Override
    public List<UserDTO> list() {
        List<User> users = userRepositoryPort.list();
        return users.stream().map(user -> new UserDTO(user)).collect(Collectors.toList());

    }
}
