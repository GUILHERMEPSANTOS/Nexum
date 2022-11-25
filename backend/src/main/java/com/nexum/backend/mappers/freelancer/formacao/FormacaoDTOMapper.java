package com.nexum.backend.dto.mappers.freelancer.formacao;

import com.nexum.backend.domain.formacao.FormacaoEntity;
import com.nexum.backend.dto.freelancer.formacao.FormacaoDTO;

import java.util.Collection;
import java.util.stream.Collectors;

public class FormacaoDTOMapper {
    public static FormacaoDTO toFormacaoDTOMapper(FormacaoEntity formacoesEntity) {
        return new FormacaoDTO(
                formacoesEntity.getId_formacao(),
                formacoesEntity.getCurso(),
                formacoesEntity.getInstituicao(),
                formacoesEntity.getCidade(),
                formacoesEntity.getEstado(),
                formacoesEntity.getSobre(),
                formacoesEntity.getData_inicial(),
                formacoesEntity.getData_final()
        );
    }

    public static Collection<FormacaoDTO> toCollectionFormacaoDTOMapper(
            Collection<FormacaoEntity> formacoesEntity
    ) {
        return formacoesEntity
                .stream()
                .map(experienciaEntity -> toFormacaoDTOMapper(experienciaEntity))
                .collect(Collectors.toList());
    }
}
