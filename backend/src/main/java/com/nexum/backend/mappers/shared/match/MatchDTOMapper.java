package com.nexum.backend.mappers.shared.match;

import com.nexum.backend.domain.match.MatchEntity;
import com.nexum.backend.controller.embargo.dto.shared.match.MatchDTO;

import java.util.Collection;
import java.util.stream.Collectors;

public class  MatchDTOMapper {
    public static MatchDTO toMatchDTOMapper(MatchEntity matchEntity) {
        return new MatchDTO(
                matchEntity.getIdContratante(),
                matchEntity.getIdFreelancer(),
                matchEntity.getId_match(),
                matchEntity.getStatus()
        );
    }

    public static Collection<MatchDTO> toCollectionMatchDTO(Collection<MatchEntity> matchEntities) {
        return matchEntities
                .stream()
                .map((matchEntity) ->
                       toMatchDTOMapper(matchEntity)
                ).collect(Collectors.toList());
    }

}
