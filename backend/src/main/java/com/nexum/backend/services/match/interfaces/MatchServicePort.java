package com.nexum.backend.services.match.interfaces;

import com.nexum.backend.dto.match.request.MatchDTORequest;

public interface MatchServicePort {
    void enviarSolicitacaoMatch(MatchDTORequest matchDTORequest);
}
