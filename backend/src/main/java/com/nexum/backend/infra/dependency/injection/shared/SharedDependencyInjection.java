package com.nexum.backend.infra.dependency.injection.shared;


import com.nexum.backend.repositories.controle.acesso.SpringUserRepository;
import com.nexum.backend.services.shered.UserService;
import com.nexum.backend.services.shered.interfaces.UserServicePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SharedDependencyInjection {

    @Bean
    UserServicePort userService(SpringUserRepository springUserRepository){
        return new UserService(springUserRepository);
    }
}
