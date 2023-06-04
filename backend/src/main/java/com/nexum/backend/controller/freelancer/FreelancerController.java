package com.nexum.backend.controller.freelancer;

import com.nexum.backend.services.freelancer.interfaces.FreelancerServicePort;
import com.nexum.backend.dto.freelancer.FreelancerDTO;

import com.nexum.backend.streaming.services.FreelancerStreamingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.IOException;
import java.util.Collection;

@RestController
@RequestMapping("api/v1/freelancer")
@CrossOrigin(origins =  {"http://nexum.hopto.org:8000", "http://localhost"})
public class FreelancerController {
    private final FreelancerServicePort freelancerServicePort;
    private final FreelancerStreamingService freelancerServiceStreaming;

    public FreelancerController(FreelancerServicePort freelancerServicePort, FreelancerStreamingService freelancerServiceStreaming) {
        this.freelancerServicePort = freelancerServicePort;
        this.freelancerServiceStreaming = freelancerServiceStreaming;
    }

    @PostMapping("create-account")
    public ResponseEntity createFreelancer(@RequestBody FreelancerDTO freelancerDTO) {
        freelancerServicePort.create(freelancerDTO);

        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("{id_freelancer}/update-endereco/{cep}")
    public ResponseEntity updateAddressByFreelancerID(
            @PathVariable String cep,
            @PathVariable Long id_freelancer
    ) throws IOException {
        freelancerServicePort.updateAddress(cep,id_freelancer);

        return ResponseEntity.status(200).build();
    }

    @GetMapping("list")
    public ResponseEntity<Collection<FreelancerDTO>> listAll() {
        return ResponseEntity.status(200).body(this.freelancerServicePort.listAll());
    }

    @GetMapping("list-with-photo")
    public StreamingResponseBody getAllUsersWithImages() {
        return freelancerServiceStreaming.streamData();
    }

    @GetMapping("{id_freelancer}")
    public ResponseEntity<FreelancerDTO> getFreelancerById(@PathVariable Long id_freelancer) {
        FreelancerDTO freelancer = this.freelancerServicePort.getById(id_freelancer);

        return ResponseEntity.status(200).body(freelancer);
    }
}

