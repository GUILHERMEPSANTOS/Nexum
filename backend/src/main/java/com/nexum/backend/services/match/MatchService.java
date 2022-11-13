package com.nexum.backend.services.match;

import com.nexum.backend.dto.mappers.match.resquest.MatchDTORequestToMatchEntityMapper;
import com.nexum.backend.dto.match.request.MatchDTORequest;

import com.nexum.backend.repositories.match.SpringMatchRepository;
import com.nexum.backend.services.match.interfaces.MatchServicePort;

public class MatchService implements MatchServicePort {
    private final SpringMatchRepository springMatchRepository;
    public MatchService(SpringMatchRepository springMatchRepository) {
        this.springMatchRepository = springMatchRepository;
    }
    @Override
    public void enviarSolicitacaoMatch(MatchDTORequest matchDTORequest) {
        // TODO: 13/11/2022 - criar validação se o match já existe (Iuri)
        this.springMatchRepository.save(
                MatchDTORequestToMatchEntityMapper.toMatchEntityMapper(matchDTORequest)
        );
    }
}
