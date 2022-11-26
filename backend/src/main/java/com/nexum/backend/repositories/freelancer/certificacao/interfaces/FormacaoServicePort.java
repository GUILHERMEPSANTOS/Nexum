package com.nexum.backend.repositories.freelancer.certificacao.interfaces;

import com.nexum.backend.dto.freelancer.formacao.FormacaoDTO;
import com.nexum.backend.dto.freelancer.formacao.request.FormacaoDTOCreateRequest;
import com.nexum.backend.dto.freelancer.formacao.request.FormacaoDTOUpdateRequest;

import java.time.LocalDate;
import java.util.Collection;

public interface FormacaoServicePort {
    FormacaoDTO create(FormacaoDTOCreateRequest formacaoDTOCreateRequest, Long id_freelancer);

    FormacaoDTO update(FormacaoDTOUpdateRequest request, Long id_formacao);

    Collection<FormacaoDTO> listByFreelancerId(Long id_freelancer);

    FormacaoDTO findById(Long id_formacao);

}
