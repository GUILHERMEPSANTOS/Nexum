package com.nexum.backend.services.freelancer;

import com.nexum.backend.domain.habilidade.HabilidadeFreelancerEntity;
import com.nexum.backend.dto.freelancer.habilidade.HabilidadeFreelancerDTO;
import com.nexum.backend.dto.freelancer.habilidade.request.HabilidadeFreelancerCreateRequest;
import com.nexum.backend.mappers.freelancer.habilidades.HabilidadeFreelancerDTOMapper;
import com.nexum.backend.mappers.freelancer.habilidades.request.HabilidadeFreelancerCreateRequestToHabilidadeFreelancerEntityMapper;
import com.nexum.backend.repositories.freelancer.habilidade.SpringHabilidadeFreelancerRepository;
import com.nexum.backend.services.freelancer.interfaces.HabilidadeFreelancerServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;


public class HabilidadeFreelancerService implements HabilidadeFreelancerServicePort {
    private final SpringHabilidadeFreelancerRepository springHabilidadeFreelancerRepository;

    public HabilidadeFreelancerService(
            SpringHabilidadeFreelancerRepository springHabilidadeFreelancerRepository
    ) {
        this.springHabilidadeFreelancerRepository = springHabilidadeFreelancerRepository;
    }

    @Override
    public Collection<HabilidadeFreelancerDTO> listHabilidadeByFreelancerId(Long id_freelancer) {
        Collection<HabilidadeFreelancerEntity> habilidadesFreelancer =
                springHabilidadeFreelancerRepository
                        .listByFreelancerID(id_freelancer);

        if (habilidadesFreelancer.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Nenhuma Habilidade encontrada");
        }

        return HabilidadeFreelancerDTOMapper.toCollectionHabilidadeFreelancerDTO(habilidadesFreelancer);
    }

    @Override
    public void handleHabilidadeFreelancer(
            Collection<HabilidadeFreelancerCreateRequest> requests
    ) {

        Collection<HabilidadeFreelancerEntity> habilidadesFreelancer =
                HabilidadeFreelancerCreateRequestToHabilidadeFreelancerEntityMapper
                        .toCollectionHabilidadeFreelancerEntity(requests);

        habilidadesFreelancer.forEach(request -> {
            if (validateSkillAlreadyRegisteredToUser(
                    request.getFreelancer().getId_usuario(),
                    request.getHabilidade().getId_habilidade()
            )
            ) {
                updateHabilidadeFreelancer(request);
            } else {
                addHabilidadeToFreelancer(request);
            }
        });
    }


    private void addHabilidadeToFreelancer(HabilidadeFreelancerEntity habilidadeFreelancerEntity) {
        springHabilidadeFreelancerRepository.save(habilidadeFreelancerEntity);
    }

    private void updateHabilidadeFreelancer(HabilidadeFreelancerEntity habilidadeFreelancerEntity) {
        springHabilidadeFreelancerRepository.updateHabilidadeFreelancer(
                habilidadeFreelancerEntity.getFreelancer().getId_usuario(),
                habilidadeFreelancerEntity.getHabilidade().getId_habilidade()
        );
    }

    @Override
    public Boolean validateSkillAlreadyRegisteredToUser(Long id_freelancer, Long id_habilidade) {
        return
                springHabilidadeFreelancerRepository
                        .validateSkillAlreadyRegisteredToUser(id_freelancer, id_habilidade);
    }
}
