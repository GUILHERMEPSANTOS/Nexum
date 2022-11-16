package com.nexum.backend.dto.mappers.match.resquest;

import com.nexum.backend.domain.controle.acesso.ContratanteEntity;
import com.nexum.backend.domain.controle.acesso.FreelancerEntity;
import com.nexum.backend.domain.match.MatchEntity;
import com.nexum.backend.dto.match.request.MatchDTORequest;

public class MatchDTORequestToMatchEntityMapper {
    public static MatchEntity toMatchEntityMapper(MatchDTORequest matchDTORequest){
        FreelancerEntity freelancer = new FreelancerEntity(matchDTORequest.getId_freelancer());
        ContratanteEntity contratante = new ContratanteEntity(matchDTORequest.getId_contratante());
        MatchEntity match = new MatchEntity();

        match.setContratante(contratante);
        match.setFreelancer(freelancer);

        return  match;
    }

}
