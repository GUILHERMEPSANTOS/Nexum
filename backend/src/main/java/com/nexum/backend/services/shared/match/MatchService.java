package com.nexum.backend.services.shared.match;

import com.nexum.backend.mappers.shared.match.resquest.MatchDTORequestToMatchEntityMapper;
import com.nexum.backend.dto.shared.match.request.MatchDTORequest;

import com.nexum.backend.repositories.shared.match.SpringMatchRepository;
import com.nexum.backend.services.shared.match.interfaces.MatchServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Transactional
public class MatchService implements MatchServicePort {
    private final SpringMatchRepository springMatchRepository;

    public MatchService(SpringMatchRepository springMatchRepository) {
        this.springMatchRepository = springMatchRepository;
    }

    @Override
    public void enviarSolicitacaoMatch(MatchDTORequest matchDTORequest) {
        Boolean alreadyExistsMatch = validateMatchRequestAlreadyExists(
                matchDTORequest.getId_freelancer(),
                matchDTORequest.getId_contratante()
        );

        if (alreadyExistsMatch) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Match já realizado!");
        }

        this.springMatchRepository.save(
                MatchDTORequestToMatchEntityMapper.toMatchEntityMapper(matchDTORequest)
        );
    }

    public Boolean validateMatchRequestAlreadyExists(Long id_freelancer, Long id_contratante) {
        return  springMatchRepository.matchRequestAlreadyExists(id_freelancer, id_contratante);
    }
}
