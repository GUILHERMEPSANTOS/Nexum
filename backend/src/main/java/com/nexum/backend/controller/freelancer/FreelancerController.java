package com.nexum.backend.controller.freelancer;

import com.nexum.backend.repositories.freelancer.certificacao.interfaces.FreelancerServicePort;
import com.nexum.backend.controller.embargo.dto.freelancer.FreelancerDTO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("api/v1/freelancer")
@CrossOrigin(origins = "*")
public class FreelancerController {
    private final FreelancerServicePort freelancerServicePort;

    public FreelancerController(FreelancerServicePort freelancerServicePort) {
        this.freelancerServicePort = freelancerServicePort;
    }

    @PostMapping("create-account")
    public ResponseEntity createContratante(@RequestBody FreelancerDTO freelancerDTO) {
        freelancerServicePort.create(freelancerDTO);

        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("list")
    public ResponseEntity<Collection<FreelancerDTO>> listAll() {
        return ResponseEntity.status(200).body(this.freelancerServicePort.listAll());
    }

    @GetMapping("{id_freelancer}")
    public ResponseEntity<FreelancerDTO> getFreelancerById(@PathVariable Long id_freelancer) {
        FreelancerDTO freelancer = this.freelancerServicePort.getById(id_freelancer);

        return ResponseEntity.status(200).body(freelancer);
    }
}

