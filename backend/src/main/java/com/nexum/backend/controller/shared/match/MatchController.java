package com.nexum.backend.controller.shared.match;

import com.nexum.backend.dto.shared.match.request.MatchDTORequest;
import com.nexum.backend.services.shared.match.interfaces.MatchServicePort;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/match")
@CrossOrigin(origins = "http://nexum.hopto.org")
public class MatchController {
    private final MatchServicePort matchServicePort;

    public MatchController(MatchServicePort matchServicePort) {
        this.matchServicePort = matchServicePort;
    }

    @PostMapping
    public ResponseEntity match(@RequestBody @Valid MatchDTORequest matchDTORequest) {
        this.matchServicePort.enviarSolicitacaoMatch(matchDTORequest);

        return ResponseEntity.status(201).build();
    }
}
