package com.nexum.backend.controller.shared.habilidade;


import com.nexum.backend.dto.shared.habilidade.HabilidadeDTO;
import com.nexum.backend.services.shared.habilidade.interfaces.HabilidadeServicePort;
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

    @GetMapping("list")
    public ResponseEntity<Collection<HabilidadeDTO>> list() {
        Collection<HabilidadeDTO> habilidades = habilidadeServicePort.listAll();

        return ResponseEntity.status(200).body(habilidades);
    }
}
