package com.nexum.backend.infra.dependency.injection.shared;

import com.nexum.backend.repositories.shared.controle.acesso.SpringUserRepository;

import com.nexum.backend.repositories.shared.photo.SpringImageRepository;
import com.nexum.backend.repositories.shared.social.SpringSocialRepository;
import com.nexum.backend.services.contratante.interfaces.ContratanteServicePort;
import com.nexum.backend.services.freelancer.interfaces.FreelancerServicePort;
import com.nexum.backend.services.shared.controle.acesso.ControleAcessoService;
import com.nexum.backend.services.shared.controle.acesso.interfaces.ControleAcessoServicePort;

import com.nexum.backend.repositories.shared.social.SpringSocialUserRepository;
import com.nexum.backend.services.shared.photo.ImageService;
import com.nexum.backend.services.shared.photo.interfaces.ImageServicePort;
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
            SpringUserRepository springUserRepository,
            FreelancerServicePort freelancerServicePort,
            ContratanteServicePort contratanteServicePort
    ) {
        return new UserService(
                springUserRepository,
                freelancerServicePort,
                contratanteServicePort
        );
    }

    @Bean
    SocialServicePort socialService(SpringSocialRepository springSocialRepository) {
        return new SocialService(springSocialRepository);
    }

    @Bean
    SocialUserServicePort socialUserService(SpringSocialUserRepository springSocialUserRepository) {
        return new SocialUserService(springSocialUserRepository);
    }

    @Bean
    ImageServicePort imageService(SpringImageRepository springImageRepository, SpringUserRepository springUserRepositor) {
        return new ImageService(springImageRepository, springUserRepositor);
    }
}
