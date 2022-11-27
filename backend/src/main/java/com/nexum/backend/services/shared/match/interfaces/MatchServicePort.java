package com.nexum.backend.services.shared.match.interfaces;

import com.nexum.backend.dto.shared.match.request.MatchDTORequest;

public interface MatchServicePort {
    void enviarSolicitacaoMatch(MatchDTORequest matchDTORequest);
    Boolean validateMatchRequestAlreadyExists(Long id_freelancer, Long id_contratante);
}
