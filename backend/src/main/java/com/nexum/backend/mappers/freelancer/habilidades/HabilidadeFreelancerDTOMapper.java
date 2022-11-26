package com.nexum.backend.repositories.contratante.mappers.freelancer.habilidades;

import com.nexum.backend.domain.habilidade.HabilidadeFreelancerEntity;
import com.nexum.backend.dto.freelancer.habilidade.HabilidadeFreelancerDTO;
import com.nexum.backend.repositories.contratante.mappers.freelancer.FreelancerDTOMapper;

import java.util.Collection;
import java.util.stream.Collectors;

public class HabilidadeFreelancerDTOMapper {
    public static HabilidadeFreelancerDTO toHabilidadeFreelancerDTO(
            HabilidadeFreelancerEntity habilidadeFreelancerEntity
    ) {
        return new HabilidadeFreelancerDTO(
                habilidadeFreelancerEntity.getId_habilidade_freelancer(),
                FreelancerDTOMapper.toFreelancerDTO(habilidadeFreelancerEntity.getFreelancer()),
                HabilidadeDTOMapper.toHabilidadeDTO(habilidadeFreelancerEntity.getHabilidade()),
                habilidadeFreelancerEntity.getHasHabilidade()
        );
    }

    public static Collection<HabilidadeFreelancerDTO> toCollectionHabilidadeFreelancerDTO(
            Collection<HabilidadeFreelancerEntity> habilidadeFreelancerEntities
    ) {
        return habilidadeFreelancerEntities
                .stream()
                .map(habilidadeFreelancerEntity -> toHabilidadeFreelancerDTO(habilidadeFreelancerEntity))
                .collect(Collectors.toList());
    }
}
