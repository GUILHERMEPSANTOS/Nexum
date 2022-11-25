package com.nexum.backend.dto.mappers.freelancer.certificacao;

import com.nexum.backend.domain.certificacao.CertificacaoEntity;
import com.nexum.backend.dto.freelancer.certificacao.CertificacaoDTO;

import java.util.Collection;
import java.util.stream.Collectors;

public class CertificacaoDTOMapper {
    public static CertificacaoDTO toCertificacaoDTOMapper(CertificacaoEntity certificacaoEntity) {
        return new CertificacaoDTO(
                certificacaoEntity.getId_certificacao(),
                certificacaoEntity.getCurso(),
                certificacaoEntity.getInstituicao(),
                certificacaoEntity.getEstado(),
                certificacaoEntity.getInstituicao(),
                certificacaoEntity.getCertificacao_url()
        );
    }

    public static Collection<CertificacaoDTO> toCollectionCertificacaoDTO(
            Collection<CertificacaoEntity> certificacoes
    ) {
        return certificacoes
                .stream()
                .map(certificacao -> toCertificacaoDTOMapper(certificacao))
                .collect(Collectors.toList());
    }
}
