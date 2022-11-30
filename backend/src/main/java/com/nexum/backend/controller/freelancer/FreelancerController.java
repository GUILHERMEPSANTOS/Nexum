package com.nexum.backend.controller.freelancer;

import com.nexum.backend.services.freelancer.interfaces.FreelancerServicePort;
import com.nexum.backend.dto.freelancer.FreelancerDTO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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

    @GetMapping("{id_freelancer}")
    public ResponseEntity<FreelancerDTO> getFreelancerById(@PathVariable Long id_freelancer) {
        FreelancerDTO freelancer = this.freelancerServicePort.getById(id_freelancer);

        return ResponseEntity.status(200).body(freelancer);
    }
}

