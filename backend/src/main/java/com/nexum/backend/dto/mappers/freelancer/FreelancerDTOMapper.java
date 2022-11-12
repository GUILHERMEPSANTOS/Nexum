package com.nexum.backend.dto.mappers.freelancer;

import com.nexum.backend.domain.controle.acesso.FreelancerEntity;

import com.nexum.backend.dto.freelancer.FreelancerDTO;
import com.nexum.backend.dto.mappers.endereco.EnderecoDTOMapper;
import com.nexum.backend.dto.mappers.habilidades.HabilidadeDTOMapper;
import com.nexum.backend.dto.mappers.match.MatchDTOMapper;
import com.nexum.backend.dto.mappers.social.SocialUserDTOMapper;

import java.util.Collection;
import java.util.stream.Collectors;

public class FreelancerDTOMapper {
    public static FreelancerDTO toFreelancerDTO(FreelancerEntity freelancerEntity) {
        return new FreelancerDTO(
                freelancerEntity.getId_usuario(),
                freelancerEntity.getNome(),
                freelancerEntity.getEmail(),
                freelancerEntity.getSenha(),
                freelancerEntity.getCelular(),
                freelancerEntity.getLogged(),
                EnderecoDTOMapper.toEnderecoDTOMapper(freelancerEntity.getEndereco()),
                HabilidadeDTOMapper.toCollectionHabilidadeDTO(freelancerEntity.getHabilidades()),
                MatchDTOMapper.toCollectionMatchDTO(freelancerEntity.getMatch()),
                SocialUserDTOMapper.toCollectionSocialUserDTO(freelancerEntity.getSocialUsers())
        );
    }

    public static Collection<FreelancerDTO> toCollectionFreelancerDTO(
            Collection<FreelancerEntity> freelancerEntities
    ) {
        return freelancerEntities
                .stream()
                .map(freelancer -> toFreelancerDTO(freelancer))
                .collect(Collectors.toList());
    }
}

