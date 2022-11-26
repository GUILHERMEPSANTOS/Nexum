package com.nexum.backend.mappers.freelancer.formacao.match;

import com.nexum.backend.domain.controle.acesso.ContratanteEntity;
import com.nexum.backend.dto.freelancer.match.queries.GetMatchRequestsByFreelancerIdQuery;
import com.nexum.backend.mappers.shared.endereco.EnderecoDTOMapper;
import com.nexum.backend.mappers.shared.social.SocialUserDTOMapper;

import java.util.Collection;

import java.util.stream.Collectors;

public class GetMatchRequestsByFreelancerIdQueryMapper {
    public static GetMatchRequestsByFreelancerIdQuery toGetMatchRequestsByFreelancerIdQuery(
            ContratanteEntity contratante
    ) {
        return new GetMatchRequestsByFreelancerIdQuery(
                contratante.getId_usuario(),
                contratante.getNome(),
                contratante.getEmail(),
                EnderecoDTOMapper.toEnderecoDTOMapper(contratante.getEndereco()),
                contratante.getSobre(),
                SocialUserDTOMapper.toCollectionSocialUserDTO(contratante.getSocialUsers())
        );
    }

    public static  Collection<GetMatchRequestsByFreelancerIdQuery> toCollectionGetMatchRequestsByFreelancerIdQuery(
            Collection<ContratanteEntity> contratantes
    ) {
        return contratantes
                .stream()
                .map(GetMatchRequestsByFreelancerIdQueryMapper::toGetMatchRequestsByFreelancerIdQuery)
                .collect(Collectors.toList());
    }
}
