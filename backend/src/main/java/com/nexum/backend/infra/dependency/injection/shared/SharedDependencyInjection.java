package com.nexum.backend.infra.dependency.injection.shared;

import com.nexum.backend.repositories.shared.controle.acesso.SpringUserRepository;

import com.nexum.backend.repositories.shared.social.SpringSocialRepository;
import com.nexum.backend.services.shared.controle.acesso.ControleAcessoService;
import com.nexum.backend.services.shared.controle.acesso.interfaces.ControleAcessoServicePort;

import com.nexum.backend.repositories.shared.social.SpringSocialUserRepository;
import com.nexum.backend.services.freelancer.interfaces.HabilidadeServicePort;
import com.nexum.backend.services.shared.social.SocialUserService;
import com.nexum.backend.services.shared.social.interfaces.SocialServicePort;
import com.nexum.backend.services.shared.social.SocialService;
import com.nexum.backend.services.shared.social.interfaces.SocialUserServicePort;
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

    @Bean
    UserServicePort userService(
            SpringUserRepository springUserRepository
    ) {
        return new UserService(springUserRepository);
    }

    @Bean
    SocialServicePort socialService(SpringSocialRepository springSocialRepository) {
        return new SocialService(springSocialRepository);
    }

    @Bean
    SocialUserServicePort socialUserService(SpringSocialUserRepository springSocialUserRepository) {
        return new SocialUserService(springSocialUserRepository);
    }
}
