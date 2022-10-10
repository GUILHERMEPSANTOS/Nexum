package com.nexum.backend.services.controle.acesso;

import com.nexum.backend.domain.controle.acesso.ContratanteEntity;
import com.nexum.backend.domain.controle.acesso.FreelancerEntity;
import com.nexum.backend.domain.controle.acesso.RoleEntity;
import com.nexum.backend.domain.controle.acesso.UserEntity;
import com.nexum.backend.dto.controle.acesso.UserDTO;
import com.nexum.backend.enums.RoleName;
import com.nexum.backend.repositories.controle.acesso.SpringRoleRepository;
import com.nexum.backend.repositories.controle.acesso.SpringUserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImp {
    private final SpringUserRepository springUserRepository;
    private final SpringRoleRepository springRoleRepository;

    public UserServiceImp(SpringUserRepository springUserRepository, SpringRoleRepository springRoleRepository) {
        this.springUserRepository = springUserRepository;
        this.springRoleRepository = springRoleRepository;
    }

    public void createContratante(UserDTO userDTO) {
        UserEntity user = new ContratanteEntity(userDTO);

        RoleEntity role = springRoleRepository.findByRoleName(RoleName.ROLE_CONTRATANTE);

        user.getRoles().add(role);

        springUserRepository.save(user);
    }


    public void createFreelancer(UserDTO userDTO) {
        UserEntity user = new FreelancerEntity(userDTO);

        RoleEntity role = springRoleRepository.findByRoleName(RoleName.ROLE_FREELANCER);

        user.getRoles().add(role);

        springUserRepository.save(user);
    }

    public List<UserDTO> list() {
        List<UserEntity> users = springUserRepository.findAll();
        return users.stream().map(user -> new UserDTO(user)).collect(Collectors.toList());

    }
}