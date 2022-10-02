package com.nexum.repositories.controle.acesso;

import com.nexum.entities.controle.acesso.*;
import com.nexum.enums.RoleName;
import com.nexum.interfaces.controle.acesso.UserRepositoryPort;
import com.nexum.validation.DomainExceptionValidation;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Transactional
public class UserRepository implements UserRepositoryPort {
    private final SpringUserRepository springUserRepository;
    private final SpringRoleRepository springRoleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserRepository(SpringUserRepository springUserRepository,
                          SpringRoleRepository springRoleRepository,
                          PasswordEncoder passwordEncoder) {
        this.springUserRepository = springUserRepository;
        this.springRoleRepository = springRoleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void createContratante(User user) {

        UserEntity userEntity = new ContratanteEntity(user);

        userEntity.setSenha(
                passwordEncoder.encode(userEntity.getSenha())
        );

        RoleEntity roleEntity =
                springRoleRepository.findByRoleName(RoleName.ROLE_CONTRATANTE);

        userEntity.getRoles().add(roleEntity);

        springUserRepository.save(userEntity);
    }

    @Override
    public void createFreelancer(User user) {
        UserEntity userEntity = new FreelancerEntity(user);

        userEntity.setSenha(
                passwordEncoder.encode(userEntity.getSenha())
        );

        RoleEntity roleEntity =
                springRoleRepository.findByRoleName(RoleName.ROLE_FREELANCER);

        userEntity.getRoles().add(roleEntity);

        springUserRepository.save(userEntity);
    }

    @Override
    public List<User> list() {
        List<UserEntity> userEntities = springUserRepository.findAll();
        return userEntities.stream().map(userEntity -> {
            try {
                return userEntity.toUser();
            } catch (DomainExceptionValidation e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toList());
    }
}
