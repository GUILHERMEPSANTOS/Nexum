package com.nexum.backend.infra.dependency.injection.shared;

import com.nexum.backend.repositories.shared.SpringHabilidadeRepository;
import com.nexum.backend.repositories.shared.controle.acesso.SpringUserRepository;

import com.nexum.backend.services.shared.controle.acesso.ControleAcessoService;
import com.nexum.backend.services.shared.controle.acesso.interfaces.ControleAcessoServicePort;

import com.nexum.backend.services.freelancer.HabilidadeService;
import com.nexum.backend.services.freelancer.interfaces.HabilidadeServicePort;
import com.nexum.backend.services.shared.user.Interfaces.UserServicePort;
import com.nexum.backend.services.shared.user.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SharedDependencyInjection {
    @Bean
    ControleAcessoServicePort userControleAcesso(SpringUserRepository springUserRepository) {
        return new ControleAcessoService(springUserRepository);
    }

//    @Bean
//    HabilidadeServicePort habilidadeService(
//            SpringHabilidadeRepository springHabilidadeRepository
//    ) {
//        return new HabilidadeService(springHabilidadeRepository);
//    }

    @Bean
    UserServicePort userService(
            SpringUserRepository springUserRepository,
            HabilidadeServicePort habilidadeServicePort
    ) {
        return new UserService(springUserRepository,habilidadeServicePort);
    }
}
