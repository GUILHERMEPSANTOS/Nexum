package com.nexum.backend.infra.dependency.injection.freelancer;

import com.nexum.backend.repositories.freelancer.certificacao.SpringCertificacaoRepository;
import com.nexum.backend.repositories.shared.controle.acesso.SpringRoleRepository;
import com.nexum.backend.repositories.freelancer.experiencia.SpringExperienciaRepository;
import com.nexum.backend.repositories.freelancer.formacao.SpringFormacaoRepository;
import com.nexum.backend.repositories.freelancer.SpringFreelancerRepository;

import com.nexum.backend.services.freelancer.CertificacaoService;
import com.nexum.backend.services.freelancer.ExperienciaService;
import com.nexum.backend.services.freelancer.FormacaoService;
import com.nexum.backend.services.freelancer.FreelancerService;
import com.nexum.backend.services.freelancer.interfaces.CertificacaoServicePort;
import com.nexum.backend.services.freelancer.interfaces.ExperienciaServicePort;
import com.nexum.backend.services.freelancer.interfaces.FormacaoServicePort;
import com.nexum.backend.services.freelancer.interfaces.FreelancerServicePort;

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
            FreelancerServicePort freelancerServicePort
    ) {
        return new FormacaoService(springFormacaoRepository, freelancerServicePort);
    }
    @Bean
    ExperienciaServicePort experienciaService(
            FreelancerServicePort freelancerServicePort,
            SpringExperienciaRepository springExperienciaRepository
    ) {
        return new ExperienciaService(
                freelancerServicePort,
                springExperienciaRepository
        );
    }
    @Bean
    CertificacaoServicePort certificacaoService(
            SpringCertificacaoRepository springCertificacaoRepository,
            FreelancerServicePort freelancerServicePort
    ) {
        return new CertificacaoService(
                springCertificacaoRepository,
                freelancerServicePort
        );
    }

}