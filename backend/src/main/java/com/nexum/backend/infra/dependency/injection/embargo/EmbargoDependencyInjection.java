package com.nexum.backend.infra.dependency.injection.embargo;

import com.nexum.backend.repositories.embargo.SpringEmbargoRepository;
import com.nexum.backend.services.embargo.EmbargoService;
import com.nexum.backend.services.embargo.interfaces.EmbargoServicePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmbargoDependencyInjection {

    @Bean
    EmbargoServicePort embargoService(SpringEmbargoRepository springEmbargoRepository) {
       return new EmbargoService(springEmbargoRepository);
    }
}
