package com.nexum.backend.controller.freelancer.formacao;

import com.nexum.backend.dto.freelancer.formacao.FormacaoDTO;
import com.nexum.backend.dto.freelancer.formacao.request.FormacaoDTOCreateRequest;
import com.nexum.backend.dto.freelancer.formacao.request.FormacaoDTOUpdateRequest;
import com.nexum.backend.services.freelancer.interfaces.FormacaoServicePort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("api/v1/formacao")
@CrossOrigin(origins = "*")
public class FormacaoController {
    private final FormacaoServicePort formacaoServicePort;

    public FormacaoController(FormacaoServicePort formacaoServicePort) {
        this.formacaoServicePort = formacaoServicePort;
    }

    @PostMapping("{id_freelancer}")
    public ResponseEntity<FormacaoDTO> create(
            @RequestBody FormacaoDTOCreateRequest formacaoDTOCreateRequest,
            @PathVariable Long id_freelancer
    ) {
        FormacaoDTO enderecoDTO = formacaoServicePort
                .create(formacaoDTOCreateRequest, id_freelancer);

        return ResponseEntity.status(201).body(enderecoDTO);
    }

    @PutMapping("{id_formacao}")
    public ResponseEntity<FormacaoDTO> update(
            @RequestBody FormacaoDTOUpdateRequest request,
            @PathVariable Long id_formacao
    ) {
        return ResponseEntity
                .status(200)
                .body(formacaoServicePort.update(request, id_formacao));
    }

    @GetMapping("list/freelancer/{id_freelancer}")
    public ResponseEntity<Collection<FormacaoDTO>> listByFreelancerId(@PathVariable Long id_freelancer) {
        return ResponseEntity
                .status(200)
                .body(formacaoServicePort.listByFreelancerId(id_freelancer));
    }

    @GetMapping("{id_formacao}")
    public ResponseEntity<FormacaoDTO> findById(@PathVariable Long id_formacao) {
        return ResponseEntity
                .status(200)
                .body(formacaoServicePort.findById(id_formacao));
    }
}
