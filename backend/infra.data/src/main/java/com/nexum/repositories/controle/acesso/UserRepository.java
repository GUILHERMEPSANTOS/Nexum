package com.nexum.repositories.controle.acesso;

import com.nexum.entities.controle.acesso.ContratanteEntity;
import com.nexum.entities.controle.acesso.FreelancerEntity;
import com.nexum.entities.controle.acesso.User;
import com.nexum.entities.controle.acesso.UserEntity;
import com.nexum.interfaces.UserRepositoryPort;
import com.nexum.validation.DomainExceptionValidation;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserRepository implements UserRepositoryPort {
    private final SpringUserRepository springUserRepository;

    public UserRepository(SpringUserRepository springUserRepository) {
        this.springUserRepository = springUserRepository;
    }

    @Override
    public void createContratante(User user) {
        UserEntity userEntity = new ContratanteEntity(user);

        springUserRepository.save(userEntity);
    }

    @Override
    public void createFreelancer(User user) {
        UserEntity userEntity = new FreelancerEntity(user);

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
