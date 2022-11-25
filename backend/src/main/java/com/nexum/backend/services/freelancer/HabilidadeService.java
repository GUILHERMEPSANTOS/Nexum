package com.nexum.backend.services.shared.habilidade;

import com.nexum.backend.domain.habilidade.HabilidadeEntity;
import com.nexum.backend.dto.mappers.shared.habilidades.HabilidadeDTOMapper;
import com.nexum.backend.dto.shared.habilidade.HabilidadeDTO;
import com.nexum.backend.repositories.shared.SpringHabilidadeRepository;
import com.nexum.backend.services.shared.habilidade.interfaces.HabilidadeServicePort;

import java.util.Collection;


public class HabilidadeService implements HabilidadeServicePort {
    private final SpringHabilidadeRepository springHabilidadeRepository;

    @Override
    public Boolean existsById(Long id_habilidade) {
        Boolean isValidId = springHabilidadeRepository.existsById(id_habilidade);

        if(!isValidId) {
            throw new IllegalArgumentException("ID Habilidade inválido");
        }

        return isValidId;
    }

    public HabilidadeService(
            SpringHabilidadeRepository springHabilidadeRepository
            ) {
        this.springHabilidadeRepository = springHabilidadeRepository;
    }

    @Override
    public Collection<HabilidadeDTO> listAll() {
        Collection<HabilidadeEntity> habilidades = springHabilidadeRepository.findAll();

        if (habilidades.isEmpty()) {
            throw new IllegalStateException("Nenhuma Habilidade encontrada");
        }

        return HabilidadeDTOMapper.toCollectionHabilidadeDTO(habilidades);
    }


}
