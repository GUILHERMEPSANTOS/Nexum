package com.nexum.backend.infra.dependency.injection.freelancer;

import com.nexum.backend.repositories.freelancer.SpringFreelancerRepository;
import com.nexum.backend.services.freelancer.FreelancerService;
import com.nexum.backend.services.freelancer.interfaces.FreelancerServicePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FreelancerDependencyInjection {

    @Bean
    FreelancerServicePort freelancerService(SpringFreelancerRepository springFreelancerRepository) {
        return new FreelancerService(springFreelancerRepository);
    }
}