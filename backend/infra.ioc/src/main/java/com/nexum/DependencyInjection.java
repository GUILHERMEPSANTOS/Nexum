package com.nexum;

import com.nexum.interfaces.UserRepositoryPort;
import com.nexum.interfaces.controle.acesso.UserServicePort;
import com.nexum.services.controle.acesso.UserServiceImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DependencyInjection {

    
    @Bean
    UserServicePort userService(UserRepositoryPort userRepositoryPort){
        return new UserServiceImp(userRepositoryPort);
    }
}
