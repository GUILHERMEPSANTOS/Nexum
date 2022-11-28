package com.nexum.backend.mappers.freelancer.habilidades;

import com.nexum.backend.domain.habilidade.HabilidadeFreelancerEntity;
import com.nexum.backend.dto.freelancer.habilidade.HabilidadeFreelancerDTO;
import com.nexum.backend.mappers.freelancer.FreelancerDTOMapper;

import java.util.Collection;
import java.util.stream.Collectors;

public class HabilidadeFreelancerDTOMapper {
    public static HabilidadeFreelancerDTO toHabilidadeFreelancerDTO(
            HabilidadeFreelancerEntity habilidadeFreelancerEntity
    ) {
        return new HabilidadeFreelancerDTO(
                habilidadeFreelancerEntity.getId_habilidade_freelancer(),
                habilidadeFreelancerEntity.getFreelancer().getId_usuario(),
                habilidadeFreelancerEntity.getHabilidade().getId_habilidade(),
                habilidadeFreelancerEntity.getHasHabilidade()
        );
    }

    public static Collection<HabilidadeFreelancerDTO> toCollectionHabilidadeFreelancerDTO(
            Collection<HabilidadeFreelancerEntity> habilidadeFreelancerEntities
    ) {
        return habilidadeFreelancerEntities
                .stream()
                .map(HabilidadeFreelancerDTOMapper::toHabilidadeFreelancerDTO)
                .collect(Collectors.toList());
    }
}
