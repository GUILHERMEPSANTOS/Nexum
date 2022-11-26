package com.nexum.backend.services.shared.match.interfaces;

import com.nexum.backend.mappers.shared.social.shared.match.request.MatchDTORequest;

public interface MatchServicePort {
    void enviarSolicitacaoMatch(MatchDTORequest matchDTORequest);
}
