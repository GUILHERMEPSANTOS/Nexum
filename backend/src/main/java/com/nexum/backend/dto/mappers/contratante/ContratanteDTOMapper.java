package com.nexum.backend.dto.mappers.contratante;

import com.nexum.backend.domain.controle.acesso.ContratanteEntity;
import com.nexum.backend.dto.contratante.ContratanteDTO;
import com.nexum.backend.dto.mappers.shared.endereco.EnderecoDTOMapper;
import com.nexum.backend.dto.mappers.shared.habilidades.HabilidadeDTOMapper;
import com.nexum.backend.dto.mappers.shared.match.MatchDTOMapper;
import com.nexum.backend.dto.mappers.shared.social.SocialUserDTOMapper;

import java.util.Collection;
import java.util.stream.Collectors;

public class ContratanteDTOMapper {
    public static ContratanteDTO toContratanteDTO(ContratanteEntity contratanteEntity) {


        return new ContratanteDTO(
                contratanteEntity.getId_usuario(),
                contratanteEntity.getNome(),
                contratanteEntity.getEmail(),
                contratanteEntity.getSenha(),
                contratanteEntity.getCelular(),
                contratanteEntity.getLogged(),
                EnderecoDTOMapper.toEnderecoDTOMapper(contratanteEntity.getEndereco()),
                HabilidadeDTOMapper.toCollectionHabilidadeDTO(contratanteEntity.getHabilidades()),
                MatchDTOMapper.toCollectionMatchDTO(contratanteEntity.getMatch()),
                SocialUserDTOMapper.toCollectionSocialUserDTO(contratanteEntity.getSocialUsers())
        );
    }

    public static Collection<ContratanteDTO> toCollectionContratanteDTO(
            Collection<ContratanteEntity> contratanteEntities
    ) {
        return contratanteEntities
                .stream()
                .map(contratante -> toContratanteDTO(contratante))
                .collect(Collectors.toList());
    }
}
