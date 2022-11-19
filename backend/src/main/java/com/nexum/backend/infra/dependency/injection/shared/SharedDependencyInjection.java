package com.nexum.backend.infra.dependency.injection.shared;

import com.nexum.backend.repositories.shared.controle.acesso.SpringUserRepository;

import com.nexum.backend.services.shared.controle.acesso.ControleAcessoService;
import com.nexum.backend.services.shared.controle.acesso.interfaces.ControleAcessoServicePort;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SharedDependencyInjection {
    @Bean
    ControleAcessoServicePort userService(SpringUserRepository springUserRepository){
        return new ControleAcessoService(springUserRepository);
    }
}
