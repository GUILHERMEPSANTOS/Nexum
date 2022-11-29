package com.nexum.backend.domain.controle.acesso.controller.contratante;

import com.nexum.backend.dto.contratante.ContratanteDTO;
import com.nexum.backend.services.contratante.interfaces.ContratanteServicePort;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("api/v1/contratante")
@CrossOrigin(origins = "*")
public class ContratanteController {
    private final ContratanteServicePort contratanteServicePort;

    public ContratanteController(ContratanteServicePort contratanteServicePort) {
        this.contratanteServicePort = contratanteServicePort;
    }

    @PostMapping("create-account")
    public ResponseEntity createContratante(@RequestBody ContratanteDTO contratanteDTO) {
        contratanteServicePort.create(contratanteDTO);

        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("list")
    public ResponseEntity<Collection<ContratanteDTO>> listAll() {
         Collection<ContratanteDTO> contratanteDTO = this.contratanteServicePort.listAll();

        return ResponseEntity.status(200).body(contratanteDTO);
    }

    @GetMapping("{id}")
    public ResponseEntity<ContratanteDTO> getFreelancerById(@PathVariable Long id) {
        return ResponseEntity.status(200).body(this.contratanteServicePort.getById(id));
    }
}
