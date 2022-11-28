package com.nexum.backend.services.freelancer;

import com.nexum.backend.domain.habilidade.HabilidadeEntity;
import com.nexum.backend.dto.freelancer.habilidade.HabilidadeDTO;
import com.nexum.backend.mappers.freelancer.habilidades.HabilidadeDTOMapper;
import com.nexum.backend.repositories.shared.SpringHabilidadeRepository;
import com.nexum.backend.services.freelancer.interfaces.HabilidadeServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;

public class HabilidadeService implements HabilidadeServicePort {
    private final SpringHabilidadeRepository springHabilidadeRepository;

    public HabilidadeService(SpringHabilidadeRepository springHabilidadeRepository) {
        this.springHabilidadeRepository = springHabilidadeRepository;
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
}
