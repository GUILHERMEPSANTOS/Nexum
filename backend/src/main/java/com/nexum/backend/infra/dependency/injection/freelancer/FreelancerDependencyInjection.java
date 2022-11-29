package com.nexum.backend.infra.dependency.injection.freelancer;


import com.nexum.backend.repositories.freelancer.SpringFreelancerRepository;
import com.nexum.backend.repositories.freelancer.certificacao.SpringCertificacaoRepository;
import com.nexum.backend.repositories.freelancer.experiencia.SpringExperienciaRepository;
import com.nexum.backend.repositories.freelancer.formacao.SpringFormacaoRepository;
import com.nexum.backend.repositories.freelancer.habilidade.SpringHabilidadeFreelancerRepository;
import com.nexum.backend.repositories.freelancer.habilidade.SpringHabilidadeRepository;
import com.nexum.backend.repositories.freelancer.match.SpringFreelancerMatchRepository;
import com.nexum.backend.repositories.shared.controle.acesso.SpringRoleRepository;


import com.nexum.backend.services.freelancer.*;
import com.nexum.backend.services.freelancer.interfaces.*;
import com.nexum.backend.services.shared.match.interfaces.MatchServicePort;
import com.nexum.backend.services.shared.user.Interfaces.UserServicePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FreelancerDependencyInjection {
    @Bean
    FreelancerServicePort freelancerService(
            SpringFreelancerRepository springFreelancerRepository,
            SpringRoleRepository springRoleRepository
    ) {
        return new FreelancerService(
                springFreelancerRepository,
                springRoleRepository
        );
    }

    @Bean
    FormacaoServicePort formacaoService(
            SpringFormacaoRepository springFormacaoRepository,
            FreelancerServicePort freelancerServicePort,
            UserServicePort userServicePort
    ) {
        return new FormacaoService(springFormacaoRepository, freelancerServicePort, userServicePort);
    }

    @Bean
    ExperienciaServicePort experienciaService(
            FreelancerServicePort freelancerServicePort,
            SpringExperienciaRepository springExperienciaRepository,
            UserServicePort userServicePort
    ) {
        return new ExperienciaService(
                freelancerServicePort,
                springExperienciaRepository,
                userServicePort
        );
    }

    @Bean
    CertificacaoServicePort certificacaoService(
            SpringCertificacaoRepository springCertificacaoRepository,
            FreelancerServicePort freelancerServicePort,
            UserServicePort userServicePort
    ) {
        return new CertificacaoService(
                springCertificacaoRepository,
                freelancerServicePort,
                userServicePort
        );
    }

    @Bean
    HabilidadeFreelancerServicePort habilidadeFreelancerService(
            SpringHabilidadeFreelancerRepository springHabilidadeFreelancerRepository
    ) {
        return new HabilidadeFreelancerService(
                springHabilidadeFreelancerRepository
        );
    }

    @Bean
    HabilidadeServicePort habilidadeService(SpringHabilidadeRepository springHabilidadeRepository){
        return new HabilidadeService(springHabilidadeRepository);
    }

    @Bean
    FreelancerMatchServicePort freelancerMatchService(
            SpringFreelancerMatchRepository springFreelancerMatchRepository,
            MatchServicePort matchServicePort
    ) {
        return new FreelancerMatchService(
                springFreelancerMatchRepository,
                matchServicePort
        );
    }
}