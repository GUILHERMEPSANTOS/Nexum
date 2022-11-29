package com.nexum.backend.services.admin.interfaces;

import org.springframework.core.io.InputStreamResource;

import java.io.ByteArrayInputStream;

public interface AdminServicePort {
    InputStreamResource load();

    Integer countNumberFreelancers();

    Integer countNumberContratantes();
}
