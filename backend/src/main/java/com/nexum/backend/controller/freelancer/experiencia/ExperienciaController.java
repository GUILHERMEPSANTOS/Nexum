package com.nexum.backend.controller.freelancer.experiencia;

import com.nexum.backend.dto.freelancer.experiencia.ExperienciaDTO;
import com.nexum.backend.dto.freelancer.experiencia.request.ExperienciaDTOCreateRequest;
import com.nexum.backend.dto.freelancer.experiencia.request.ExperienciaDTOUpdateRequest;
import com.nexum.backend.services.freelancer.interfaces.ExperienciaServicePort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("api/v1/experiencia")
@CrossOrigin(origins = "*")
public class ExperienciaController {
    private final ExperienciaServicePort experienciaServicePort;

    public ExperienciaController(ExperienciaServicePort experienciaServicePort) {
        this.experienciaServicePort = experienciaServicePort;
    }

    @PostMapping("{id_freelancer}")
    public ResponseEntity<ExperienciaDTO> create(
            @RequestBody ExperienciaDTOCreateRequest experienciaDTOCreateRequest,
            @PathVariable Long id_freelancer
    ) {
        ExperienciaDTO experienciaDTO = experienciaServicePort
                .create(experienciaDTOCreateRequest, id_freelancer);

        return ResponseEntity.status(201).body(experienciaDTO);
    }

    @PutMapping("{id_experiencia}")
    public ResponseEntity<ExperienciaDTO> update(
            @RequestBody ExperienciaDTOUpdateRequest experienciaDTOUpdateRequest,
            @PathVariable Long id_experiencia
    ) {
        return ResponseEntity.status(200).body(
                experienciaServicePort.update(experienciaDTOUpdateRequest, id_experiencia)
        );
    }

    @GetMapping("list/freelancer/{id_freelancer}")
    public ResponseEntity<Collection<ExperienciaDTO>> listByFreelancerId(@PathVariable Long id_freelancer) {
        return ResponseEntity.status(200).body(
                experienciaServicePort.listByFreelancerId(id_freelancer)
        );
    }

    @GetMapping("{id_experiencia}")
    public ResponseEntity<ExperienciaDTO> findById(@PathVariable Long id_experiencia) {
        return ResponseEntity.status(200).body(
                experienciaServicePort.findById(id_experiencia)
        );
    }
}
