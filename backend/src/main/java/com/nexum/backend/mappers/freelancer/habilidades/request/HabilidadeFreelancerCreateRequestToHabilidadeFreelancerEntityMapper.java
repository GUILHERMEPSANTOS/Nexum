package com.nexum.backend.mappers.freelancer.habilidades.request;

import com.nexum.backend.domain.controle.acesso.FreelancerEntity;
import com.nexum.backend.domain.habilidade.HabilidadeEntity;
import com.nexum.backend.domain.habilidade.HabilidadeFreelancerEntity;
import com.nexum.backend.dto.freelancer.habilidade.request.HabilidadeFreelancerCreateRequest;

import java.util.Collection;
import java.util.stream.Collectors;

public class HabilidadeFreelancerCreateRequestToHabilidadeFreelancerEntityMapper {
    public static HabilidadeFreelancerEntity toHabilidadeFreelancerEntity(
            HabilidadeFreelancerCreateRequest habilidadeFreelancerCreateRequest
    ) {
        return new HabilidadeFreelancerEntity(
                new FreelancerEntity(habilidadeFreelancerCreateRequest.getId_freelancer()),
                new HabilidadeEntity(habilidadeFreelancerCreateRequest.getId_habilidade()),
                true
        );
    }

    public static Collection<HabilidadeFreelancerEntity> toCollectionHabilidadeFreelancerEntity(
            Collection<HabilidadeFreelancerCreateRequest> habilidadeFreelancerCreateRequests
    ) {
        return habilidadeFreelancerCreateRequests
                .stream()
                .map(habilidadeFreelancerCreateRequest ->
                        toHabilidadeFreelancerEntity(habilidadeFreelancerCreateRequest)
                )
                .collect(Collectors.toList());
    }
}
