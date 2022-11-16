package com.nexum.backend.services.contratante.interfaces;

import com.nexum.backend.dto.contratante.ContratanteDTO;
import com.nexum.backend.dto.shared.UserDTO;

import java.util.Collection;

public interface ContratanteServicePort {
    void create(ContratanteDTO contratanteDTO);

    Collection<ContratanteDTO> listAll();

    ContratanteDTO getById(Long id);
}
