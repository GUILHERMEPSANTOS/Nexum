package com.nexum.backend.controller.freelancer.habilidade;


import com.nexum.backend.dto.freelancer.habilidade.HabilidadeDTO;
import com.nexum.backend.dto.freelancer.habilidade.HabilidadeFreelancerDTO;
import com.nexum.backend.repositories.freelancer.certificacao.interfaces.HabilidadeServicePort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("api/v1/habilidade")
public class HabilidadeController {

    private final HabilidadeServicePort habilidadeServicePort;

    public HabilidadeController(HabilidadeServicePort habilidadeServicePort) {
        this.habilidadeServicePort = habilidadeServicePort;
    }


    @GetMapping("habilidade")
    public ResponseEntity<Collection<HabilidadeDTO>> list() {
        Collection<HabilidadeDTO> habilidades = habilidadeServicePort.listAllHabilidades();

        return ResponseEntity.status(200).body(habilidades);
    }

    @GetMapping("list/habilidade-freelancer/{id_freelancer}")
    public ResponseEntity<Collection<HabilidadeFreelancerDTO>> listHabilidadeFreelancer(
            @PathVariable Long id_freelancer
    ) {
        Collection<HabilidadeFreelancerDTO> habilidadeFreelancer =
                habilidadeServicePort.listHabilidadeFreelancer(id_freelancer);

        return ResponseEntity.status(200).body(habilidadeFreelancer);
    }

}
