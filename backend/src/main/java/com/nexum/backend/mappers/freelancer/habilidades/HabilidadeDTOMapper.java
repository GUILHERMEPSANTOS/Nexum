package com.nexum.backend.mappers.freelancer.habilidades;

import com.nexum.backend.domain.habilidade.HabilidadeEntity;
import com.nexum.backend.controller.embargo.dto.freelancer.habilidade.HabilidadeDTO;

import java.util.Collection;
import java.util.stream.Collectors;

public class HabilidadeDTOMapper {
    public static HabilidadeDTO toHabilidadeDTO(HabilidadeEntity habilidadeEntity) {
        return new HabilidadeDTO(
                habilidadeEntity.getId_habilidade(),
                habilidadeEntity.getNome()
        );
    }

    public static Collection<HabilidadeDTO> toCollectionHabilidadeDTO(
            Collection<HabilidadeEntity> habilidadeEntities
    ) {
        return habilidadeEntities
                .stream()
                .map((habilidadeEntity) ->
                      toHabilidadeDTO(habilidadeEntity)
                ).collect(Collectors.toList());
    }
}
