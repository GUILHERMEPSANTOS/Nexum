package com.nexum.backend.services.shared.habilidade.interfaces;

import com.nexum.backend.dto.shared.habilidade.HabilidadeDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

public interface HabilidadeServicePort {
    Collection<HabilidadeDTO> listAll();

    Boolean existsById(Long id_habilidade);

}
