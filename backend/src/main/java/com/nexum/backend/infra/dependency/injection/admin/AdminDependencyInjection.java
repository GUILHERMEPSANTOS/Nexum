package com.nexum.backend.infra.dependency.injection.admin;

import com.nexum.backend.repositories.controle.acesso.SpringUserRepository;
import com.nexum.backend.services.admin.AdminService;
import com.nexum.backend.services.admin.interfaces.AdminServicePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdminDependencyInjection {
    @Bean
    AdminServicePort adminService(SpringUserRepository springUserRepository) {
        return new AdminService(springUserRepository);
    }
}
