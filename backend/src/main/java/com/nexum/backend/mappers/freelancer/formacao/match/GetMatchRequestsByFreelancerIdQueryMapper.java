package com.nexum.backend.mappers.freelancer.match;

import com.nexum.backend.domain.controle.acesso.ContratanteEntity;
import com.nexum.backend.dto.freelancer.match.GetMatchRequestsByFreelancerIdQuery;
import com.nexum.backend.dto.shared.endereco.EnderecoDTO;
import com.nexum.backend.dto.shared.social.SocialUserDTO;

public class GetMatchRequestsByFreelancerIdQueryMapper {
    private GetMatchRequestsByFreelancerIdQueryMapper toGetMatchRequestsByFreelancerIdQueryMapper(
            ContratanteEntity contratante
    ){
        return new GetMatchRequestsByFreelancerIdQuery(
                contratante.getId_usuario(),
                contratante.getNome(),
                contratante.getEmail(),

                EnderecoDTO endereco,
                String sobre,
                Collection< SocialUserDTO > socialsUserDTO
        )
    }
}
