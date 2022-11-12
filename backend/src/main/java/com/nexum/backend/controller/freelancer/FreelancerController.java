package com.nexum.backend.controller.freelancer;

import com.nexum.backend.services.freelancer.interfaces.FreelancerServicePort;
import com.nexum.backend.dto.freelancer.FreelancerDTO;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("api/v1/freelancer")
public class FreelancerController {
    private final FreelancerServicePort freelancerServicePort;

    public FreelancerController(FreelancerServicePort freelancerServicePort) {
        this.freelancerServicePort = freelancerServicePort;
    }

    @GetMapping("list")
    public ResponseEntity<Collection<FreelancerDTO>> list() {
        return ResponseEntity.status(200).body(this.freelancerServicePort.listAll());
    }
}
