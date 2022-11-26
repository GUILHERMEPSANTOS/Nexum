package com.nexum.backend.repositories.contratante.mappers.freelancer.experiencia;

import com.nexum.backend.domain.experiencia.ExperienciaEntity;
import com.nexum.backend.dto.freelancer.experiencia.ExperienciaDTO;

import java.util.Collection;
import java.util.stream.Collectors;

public class ExperienciaDTOMapper {
    public static ExperienciaDTO toExperienciaDTOMapper(ExperienciaEntity experienciaEntity) {
        return new ExperienciaDTO(
                experienciaEntity.getId_experiencia(),
                experienciaEntity.getCargo(),
                experienciaEntity.getEmpresa(),
                experienciaEntity.getCidade(),
                experienciaEntity.getEstado(),
                experienciaEntity.getSobre(),
                experienciaEntity.getData_inicial(),
                experienciaEntity.getData_final()
        );
    }

    public static Collection<ExperienciaDTO> toCollectionExperienciaDTOMapper(
            Collection<ExperienciaEntity> experienciasEntity
    ) {
        return experienciasEntity
                .stream()
                .map(experienciaEntity -> toExperienciaDTOMapper(experienciaEntity))
                .collect(Collectors.toList());
    }
}
