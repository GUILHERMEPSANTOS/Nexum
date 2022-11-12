package com.nexum.backend.infra.dependency.injection.contratante;

import com.nexum.backend.repositories.contratante.SpringContratanteRepository;
import com.nexum.backend.repositories.controle.acesso.SpringRoleRepository;
import com.nexum.backend.services.contratante.ContratanteService;
import com.nexum.backend.services.contratante.interfaces.ContratanteServicePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContratanteDependencyInjection {

    @Bean
    ContratanteServicePort contratanteService(
            SpringContratanteRepository springContratanteRepository,
            SpringRoleRepository springRoleRepository
    ) {
        return new ContratanteService(
                springContratanteRepository,
                springRoleRepository
        );
    }
}
