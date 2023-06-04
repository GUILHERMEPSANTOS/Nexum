package com.nexum.backend.mappers.freelancer;

import com.nexum.backend.domain.controle.acesso.FreelancerEntity;

import com.nexum.backend.dto.freelancer.FreelancerDTO;
import com.nexum.backend.dto.shared.photo.ImageDTO;
import com.nexum.backend.mappers.freelancer.experiencia.ExperienciaDTOMapper;
import com.nexum.backend.mappers.freelancer.formacao.FormacaoDTOMapper;
import com.nexum.backend.mappers.freelancer.habilidades.HabilidadeFreelancerDTOMapper;
import com.nexum.backend.mappers.shared.endereco.EnderecoDTOMapper;
import com.nexum.backend.mappers.shared.match.MatchDTOMapper;
import com.nexum.backend.mappers.shared.photo.ImageDTOMapper;
import com.nexum.backend.mappers.shared.social.SocialUserDTOMapper;

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
                freelancerEntity.getSobre(),
                EnderecoDTOMapper.toEnderecoDTOMapper(freelancerEntity.getEndereco()),
                HabilidadeFreelancerDTOMapper.toCollectionHabilidadeFreelancerDTO(freelancerEntity.getHabilidades_freelancer()),
                MatchDTOMapper.toCollectionMatchDTO(freelancerEntity.getMatch()),
                SocialUserDTOMapper.toCollectionSocialUserDTO(freelancerEntity.getSocialUsers()),
                ExperienciaDTOMapper.toCollectionExperienciaDTOMapper(freelancerEntity.getExperiencias()),
                FormacaoDTOMapper.toCollectionFormacaoDTOMapper(freelancerEntity.getFormacao()),
                ImageDTOMapper.toImageDTOMapper(null)
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

