package com.nexum.backend.repositories.freelancer.certificacao.interfaces;

import com.nexum.backend.dto.freelancer.experiencia.ExperienciaDTO;
import com.nexum.backend.dto.freelancer.experiencia.request.ExperienciaDTOCreateRequest;
import com.nexum.backend.dto.freelancer.experiencia.request.ExperienciaDTOUpdateRequest;

import java.util.Collection;

public interface ExperienciaServicePort {
    ExperienciaDTO create(
            ExperienciaDTOCreateRequest request,
            Long id_freelancer
    );

    ExperienciaDTO update(
            ExperienciaDTOUpdateRequest experienciaDTOUpdateRequest,
            Long id_experiencia
    );

    Collection<ExperienciaDTO> listByFreelancerId(Long id_freelancer);

    ExperienciaDTO findById(Long id_experiencia);
}
