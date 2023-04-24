package com.nexum.backend.controller.freelancer.habilidade;

import com.nexum.backend.dto.freelancer.habilidade.HabilidadeFreelancerDTO;
import com.nexum.backend.dto.freelancer.habilidade.request.HabilidadeFreelancerCreateRequest;
import com.nexum.backend.services.freelancer.interfaces.HabilidadeFreelancerServicePort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("api/v1/freelancer/{id_freelancer}/habilidade")
@CrossOrigin(origins = "https://nexum.hopto.org")
public class HabilidadeFreelancerController {

    private final HabilidadeFreelancerServicePort habilidadeFreelancerServicePort;

    public HabilidadeFreelancerController(
            HabilidadeFreelancerServicePort habilidadeFreelancerServicePort
    ) {
        this.habilidadeFreelancerServicePort = habilidadeFreelancerServicePort;
    }

    @PostMapping
    public ResponseEntity handleHabilidadeFreelancer(
            @RequestBody Collection<HabilidadeFreelancerCreateRequest> request)
    {
        habilidadeFreelancerServicePort.handleHabilidadeFreelancer(request);

        return ResponseEntity.status(200).build();
    }

    @GetMapping("list")
    public ResponseEntity<Collection<HabilidadeFreelancerDTO>> listHabilidadeFreelancer(
            @PathVariable Long id_freelancer
    ) {
        Collection<HabilidadeFreelancerDTO> habilidadeFreelancer =
                habilidadeFreelancerServicePort.listHabilidadeByFreelancerId(id_freelancer);

        return ResponseEntity.status(200).body(habilidadeFreelancer);
    }

}
