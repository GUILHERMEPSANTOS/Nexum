package com.nexum.backend.repositories.freelancer.certificacao.interfaces;

import com.nexum.backend.dto.freelancer.certificacao.CertificacaoDTO;
import com.nexum.backend.dto.freelancer.certificacao.request.CertificacaoDTOCreateRequest;
import com.nexum.backend.dto.freelancer.certificacao.request.CertificacaoDTOUpdateRequest;

import java.util.Collection;

public interface CertificacaoServicePort {
    CertificacaoDTO create(CertificacaoDTOCreateRequest request, Long id_freelancer);

    CertificacaoDTO update(CertificacaoDTOUpdateRequest request, Long id_certificacao);

    Collection<CertificacaoDTO> listByFreelancerId(Long id_freelancer);

    CertificacaoDTO findById(Long id_certificacao);

     Boolean existsById(Long id_certificacao);

}
