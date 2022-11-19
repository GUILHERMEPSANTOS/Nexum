package com.nexum.backend.dto.mappers.freelancer;

import com.nexum.backend.domain.controle.acesso.FreelancerEntity;

import com.nexum.backend.dto.freelancer.FreelancerDTO;
import com.nexum.backend.dto.mappers.freelancer.experiencia.ExperienciaDTOMapper;
import com.nexum.backend.dto.mappers.freelancer.formacao.FormacaoDTOMapper;
import com.nexum.backend.dto.mappers.shared.endereco.EnderecoDTOMapper;
import com.nexum.backend.dto.mappers.shared.habilidades.HabilidadeDTOMapper;
import com.nexum.backend.dto.mappers.shared.match.MatchDTOMapper;
import com.nexum.backend.dto.mappers.shared.social.SocialUserDTOMapper;

import java.util.Collection;
import java.util.Optional;
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
                SocialUserDTOMapper.toCollectionSocialUserDTO(freelancerEntity.getSocialUsers()),
                ExperienciaDTOMapper.toCollectionExperienciaDTOMapper(freelancerEntity.getExperiencias()),
                FormacaoDTOMapper.toCollectionFormacaoDTOMapper(freelancerEntity.getFormacao())
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

