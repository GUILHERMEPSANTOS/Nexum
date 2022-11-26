package com.nexum.backend.controller.shared.match;

import com.nexum.backend.controller.embargo.dto.shared.match.request.MatchDTORequest;
import com.nexum.backend.services.shared.match.interfaces.MatchServicePort;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/match")
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
