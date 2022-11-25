package com.nexum.backend.controller.freelancer.certificacao;

import com.nexum.backend.dto.freelancer.certificacao.CertificacaoDTO;
import com.nexum.backend.dto.freelancer.certificacao.request.CertificacaoDTOCreateRequest;
import com.nexum.backend.dto.freelancer.certificacao.request.CertificacaoDTOUpdateRequest;
import com.nexum.backend.services.freelancer.interfaces.CertificacaoServicePort;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("api/v1/certificacao")
@CrossOrigin(origins = "*")
public class CertificacaoController {
    private final CertificacaoServicePort certificacaoServicePort;

    public CertificacaoController(CertificacaoServicePort certificacaoServicePort) {
        this.certificacaoServicePort = certificacaoServicePort;
    }

    @PostMapping("{id_freelancer}")
    public ResponseEntity<CertificacaoDTO> create(
            @PathVariable Long id_freelancer,
            @RequestBody CertificacaoDTOCreateRequest request
    ) {
        CertificacaoDTO certificacao = certificacaoServicePort.create(request, id_freelancer);

        return ResponseEntity.status(201).body(certificacao);
    }

    @PutMapping("{id_certificacao}")
    public ResponseEntity<CertificacaoDTO> update(
            @PathVariable Long id_certificacao,
            @RequestBody CertificacaoDTOUpdateRequest request
    ) {
        CertificacaoDTO certificacao = certificacaoServicePort.update(request, id_certificacao);

        return ResponseEntity.status(200).body(certificacao);
    }

    @GetMapping("list/freelancer/{id_freelancer}")
    public ResponseEntity<Collection<CertificacaoDTO>> listByFreelancerId(@PathVariable Long id_freelancer) {

        Collection<CertificacaoDTO> certificacoes =
                certificacaoServicePort.listByFreelancerId(id_freelancer);

        return ResponseEntity.status(200).body(certificacoes);
    }

    @GetMapping("{id_certificacao}")
    public ResponseEntity<CertificacaoDTO> findById(@PathVariable Long id_certificacao) {
        CertificacaoDTO certificacao = certificacaoServicePort.findById(id_certificacao);

        return ResponseEntity.status(200).body(certificacao);
    }
}
