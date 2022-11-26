package com.nexum.backend.infra.dependency.injection.match;

import com.nexum.backend.repositories.shared.match.SpringMatchRepository;

import com.nexum.backend.services.shared.match.MatchService;
import com.nexum.backend.services.shared.match.interfaces.MatchServicePort;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MatchDependencyInjection {

    @Bean
    MatchServicePort matchService(SpringMatchRepository springMatchRepository) {
        return new MatchService(springMatchRepository);
    }
}
