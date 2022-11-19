package com.nexum.backend.services.freelancer;

import com.nexum.backend.domain.controle.acesso.FreelancerEntity;
import com.nexum.backend.domain.formacao.FormacaoEntity;
import com.nexum.backend.dto.freelancer.formacao.FormacaoDTO;
import com.nexum.backend.dto.freelancer.formacao.request.FormacaoDTOCreateRequest;
import com.nexum.backend.dto.freelancer.formacao.request.FormacaoDTOUpdateRequest;
import com.nexum.backend.dto.mappers.freelancer.formacao.FormacaoDTOMapper;
import com.nexum.backend.repositories.freelancer.formacao.SpringFormacaoRepository;
import com.nexum.backend.services.freelancer.interfaces.FormacaoServicePort;
import com.nexum.backend.services.freelancer.interfaces.FreelancerServicePort;

import java.util.Collection;
import java.util.Optional;

public class FormacaoService implements FormacaoServicePort {
    private final SpringFormacaoRepository springFormacaoRepository;
    private final FreelancerServicePort freelancerServicePort;

    public FormacaoService(
            SpringFormacaoRepository springFormacaoRepository,
            FreelancerServicePort freelancerServicePort
    ) {
        this.springFormacaoRepository = springFormacaoRepository;
        this.freelancerServicePort = freelancerServicePort;
    }

    @Override
    public FormacaoDTO create(
            FormacaoDTOCreateRequest formacaoDTOCreateRequest,
            Long id_freelancer
    ) {

        freelancerServicePort.existsById(id_freelancer);

        FormacaoEntity formacao = new FormacaoEntity(
                formacaoDTOCreateRequest.getCurso(),
                formacaoDTOCreateRequest.getInstituicao(),
                formacaoDTOCreateRequest.getCidade(),
                formacaoDTOCreateRequest.getEstado(),
                formacaoDTOCreateRequest.getSobre(),
                formacaoDTOCreateRequest.getData_inicial(),
                formacaoDTOCreateRequest.getData_final(),
                new FreelancerEntity(id_freelancer)
        );

        if (formacao == null) {
            throw new IllegalArgumentException("Erro ao criar Formação");
        }

        return FormacaoDTOMapper
                .toFormacaoDTOMapper(this.springFormacaoRepository.save(formacao));
    }

    @Override
    public FormacaoDTO update(FormacaoDTOUpdateRequest request, Long id_formacao) {
        Optional<FormacaoEntity> formacaoEntity = springFormacaoRepository.findById(id_formacao);

        if (!formacaoEntity.isPresent()) {
            throw new IllegalArgumentException("ID da informação é invalido");
        }

        formacaoEntity.get().update(
                request.getCurso(),
                request.getInstituicao(),
                request.getCidade(),
                request.getEstado(),
                request.getSobre(),
                request.getData_inicial(),
                request.getData_final()
        );

        return FormacaoDTOMapper
                .toFormacaoDTOMapper(
                        springFormacaoRepository.save(formacaoEntity.get())
                );
    }

    @Override
    public Collection<FormacaoDTO> listByFreelancerId(Long id_freelancer) {
        freelancerServicePort.existsById(id_freelancer);

        return FormacaoDTOMapper
                .toCollectionFormacaoDTOMapper(springFormacaoRepository.findByFreelancerId(id_freelancer));
    }

    @Override
    public FormacaoDTO findById(Long id_formacao) {
        Optional<FormacaoEntity> formacao = springFormacaoRepository.findById(id_formacao);

        if(!formacao.isPresent()){
            throw new IllegalArgumentException("ID Formação inválido");
        }

        return FormacaoDTOMapper.toFormacaoDTOMapper(formacao.get());
    }
}
