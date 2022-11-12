package com.nexum.backend.dto.mappers.endereco;

import com.nexum.backend.domain.endereco.EnderecoEntity;
import com.nexum.backend.dto.endereco.EnderecoDTO;

public class EnderecoDTOMapper {
    public static EnderecoDTO toEnderecoDTOMapper(EnderecoEntity enderecoEntity) {
        return new EnderecoDTO(enderecoEntity.getCidade(), enderecoEntity.getEstado());
    }
}
