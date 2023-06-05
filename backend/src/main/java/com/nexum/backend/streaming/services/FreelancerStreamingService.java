package com.nexum.backend.streaming.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nexum.backend.dto.freelancer.FreelancerDTO;
import com.nexum.backend.infra.streaming.AbstractStreamingService;
import com.nexum.backend.services.freelancer.interfaces.FreelancerServicePort;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;

public class FreelancerStreamingService extends AbstractStreamingService<FreelancerDTO> {

    private final FreelancerServicePort freelancerServicePort;

    public FreelancerStreamingService(FreelancerServicePort freelancerServicePort) {
        this.freelancerServicePort = freelancerServicePort;
    }

    @Override
    protected Collection<FreelancerDTO> getData() {
        return freelancerServicePort.listAllWithImage();
    }

    @Override
    protected void writeData(FreelancerDTO data, OutputStream outputStream) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String userJson = objectMapper.writeValueAsString(data);
        outputStream.write(userJson.getBytes());
    }
}

