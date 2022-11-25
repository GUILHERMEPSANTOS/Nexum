package com.nexum.backend.dto.mappers.shared.endereco;

import com.nexum.backend.domain.endereco.EnderecoEntity;
import com.nexum.backend.dto.shared.endereco.EnderecoDTO;

public class EnderecoDTOMapper {
    public static EnderecoDTO toEnderecoDTOMapper(EnderecoEntity enderecoEntity) {
        if (enderecoEntity != null)
            return new EnderecoDTO(enderecoEntity.getCidade(), enderecoEntity.getEstado());
        else
            return null;
    }
}
