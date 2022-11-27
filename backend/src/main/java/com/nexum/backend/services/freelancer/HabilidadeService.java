package com.nexum.backend.services.freelancer;

import com.nexum.backend.domain.habilidade.HabilidadeEntity;
import com.nexum.backend.domain.habilidade.HabilidadeFreelancerEntity;
import com.nexum.backend.dto.freelancer.habilidade.HabilidadeFreelancerDTO;
import com.nexum.backend.mappers.freelancer.habilidades.HabilidadeDTOMapper;
import com.nexum.backend.dto.freelancer.habilidade.HabilidadeDTO;
import com.nexum.backend.mappers.freelancer.habilidades.HabilidadeFreelancerDTOMapper;
import com.nexum.backend.repositories.freelancer.habilidade.SpringHabilidadeFreelancerRepository;
import com.nexum.backend.repositories.shared.SpringHabilidadeRepository;
import com.nexum.backend.services.freelancer.interfaces.HabilidadeServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;


public class HabilidadeService implements HabilidadeServicePort {
    private final SpringHabilidadeRepository springHabilidadeRepository;
    private final SpringHabilidadeFreelancerRepository springHabilidadeFreelancerRepository;

    public HabilidadeService(
            SpringHabilidadeRepository springHabilidadeRepository,
            SpringHabilidadeFreelancerRepository springHabilidadeFreelancerRepository
    ) {
        this.springHabilidadeRepository = springHabilidadeRepository;
        this.springHabilidadeFreelancerRepository = springHabilidadeFreelancerRepository;
    }

    @Override
    public Boolean existsHabilidadeById(Long id_habilidade) {
        Boolean isValidId = springHabilidadeRepository.existsById(id_habilidade);

        if (!isValidId) {
            throw new IllegalArgumentException("ID Habilidade inválido");
        }

        return isValidId;
    }

    @Override
    public Collection<HabilidadeDTO> listAllHabilidades() {
        Collection<HabilidadeEntity> habilidades = springHabilidadeRepository.findAll();

        if (habilidades.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Nenhuma Habilidade encontrada");
        }

        return HabilidadeDTOMapper.toCollectionHabilidadeDTO(habilidades);
    }

    @Override
    public Collection<HabilidadeFreelancerDTO> listHabilidadeFreelancer(Long id_freelancer) {
        Collection<HabilidadeFreelancerEntity> habilidadesFreelancer =
                springHabilidadeFreelancerRepository
                        .listByFreelancerID(id_freelancer);

        if (habilidadesFreelancer.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Nenhuma Habilidade encontrada");
        }

        return HabilidadeFreelancerDTOMapper.toCollectionHabilidadeFreelancerDTO(habilidadesFreelancer);
    }
}
