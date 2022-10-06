package com.nexum.services.controle.acesso;

import com.nexum.dtos.controle.acesso.UserDTO;
import com.nexum.entities.controle.acesso.Contratante;
import com.nexum.entities.controle.acesso.Freelancer;
import com.nexum.entities.controle.acesso.Role;
import com.nexum.entities.controle.acesso.User;
import com.nexum.enums.RoleName;
import com.nexum.interfaces.controle.acesso.RoleRepositoryPort;
import com.nexum.interfaces.controle.acesso.UserRepositoryPort;
import com.nexum.interfaces.controle.acesso.UserServicePort;
import com.nexum.validation.DomainExceptionValidation;

import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImp implements UserServicePort {
    private final UserRepositoryPort userRepositoryPort;
    private final RoleRepositoryPort roleRepositoryPort;

    public UserServiceImp(UserRepositoryPort userRepositoryPort, RoleRepositoryPort roleRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
        this.roleRepositoryPort = roleRepositoryPort;
    }
    @Override
    public void createContratante(UserDTO userDTO) throws DomainExceptionValidation {
        User user = new Contratante(userDTO.getNome(), userDTO.getEmail(),
                userDTO.getSenha(), userDTO.getCpf(), userDTO.getProfissao());

        Role role = roleRepositoryPort.findRoleByName(RoleName.ROLE_CONTRATANTE);

        user.getRoles().add(role);

        userRepositoryPort.createContratante(user);
    }

    @Override
    public void createFreelancer(UserDTO userDTO) throws DomainExceptionValidation {
        User user = new Freelancer(userDTO.getNome(), userDTO.getEmail(),
                userDTO.getSenha(), userDTO.getCpf(), userDTO.getProfissao());

        Role role = roleRepositoryPort.findRoleByName(RoleName.ROLE_FREELANCER);

        user.getRoles().add(role);

        userRepositoryPort.createFreelancer(user);
    }

    @Override
    public List<UserDTO> list() {
        List<User> users = userRepositoryPort.list();
        return users.stream().map(user -> new UserDTO(user)).collect(Collectors.toList());

    }
}
