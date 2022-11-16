package com.nexum.backend.dto.mappers.habilidades;

import com.nexum.backend.domain.habilidades.HabilidadeEntity;
import com.nexum.backend.dto.habilidade.HabilidadeDTO;

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
