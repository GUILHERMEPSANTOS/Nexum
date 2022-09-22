package com.nexum.repositories.controle.acesso;

import com.nexum.entities.User;
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
    public void create(User user) {
        UserEntity userEntity = new UserEntity(user);

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
