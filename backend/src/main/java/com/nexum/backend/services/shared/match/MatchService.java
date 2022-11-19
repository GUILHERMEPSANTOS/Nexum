package com.nexum.backend.services.shared.match;

import com.nexum.backend.dto.mappers.shared.match.resquest.MatchDTORequestToMatchEntityMapper;
import com.nexum.backend.dto.shared.match.request.MatchDTORequest;

import com.nexum.backend.repositories.shared.match.SpringMatchRepository;
import com.nexum.backend.services.shared.match.interfaces.MatchServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class MatchService implements MatchServicePort {
    private final SpringMatchRepository springMatchRepository;

    public MatchService(SpringMatchRepository springMatchRepository) {
        this.springMatchRepository = springMatchRepository;
    }

    @Override
    public void enviarSolicitacaoMatch(MatchDTORequest matchDTORequest) {
        validateMatchRequestAlreadyExists(
                matchDTORequest.getId_freelancer(),
                matchDTORequest.getId_contratante()
        );

        this.springMatchRepository.save(
                MatchDTORequestToMatchEntityMapper.toMatchEntityMapper(matchDTORequest)
        );
    }

    private void validateMatchRequestAlreadyExists(Long id_freelancer, Long id_contratante) {
        Boolean reaquestAlreadlyExists =
                springMatchRepository.matchRequestAlreadyExists(id_freelancer, id_contratante);

        if (reaquestAlreadlyExists) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Match já realizado!");
        }
    }
}
