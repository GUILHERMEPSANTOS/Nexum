package com.nexum.backend.services.admin;

import com.nexum.backend.helperFile.CSVhelper;
import com.nexum.backend.repositories.shared.controle.acesso.SpringUserRepository;
import com.nexum.backend.services.admin.interfaces.AdminServicePort;
import org.springframework.core.io.InputStreamResource;

import java.io.ByteArrayInputStream;

public class AdminService implements AdminServicePort {
    private SpringUserRepository springUserRepository;
    public AdminService(SpringUserRepository springUserRepository) {
        this.springUserRepository = springUserRepository;
    }

    @Override
    public InputStreamResource load() {
        ByteArrayInputStream in = CSVhelper.userToCSV(springUserRepository.findAll());
        return new InputStreamResource(in);
    }
}
