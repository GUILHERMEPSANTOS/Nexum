package com.nexum.backend.services.freelancer;

import com.nexum.backend.domain.certificacao.CertificacaoEntity;
import com.nexum.backend.domain.controle.acesso.FreelancerEntity;
import com.nexum.backend.dto.freelancer.certificacao.CertificacaoDTO;
import com.nexum.backend.dto.freelancer.certificacao.request.CertificacaoDTOCreateRequest;
import com.nexum.backend.dto.freelancer.certificacao.request.CertificacaoDTOUpdateRequest;
import com.nexum.backend.mappers.freelancer.certificacao.CertificacaoDTOMapper;
import com.nexum.backend.repositories.freelancer.certificacao.SpringCertificacaoRepository;
import com.nexum.backend.services.freelancer.interfaces.CertificacaoServicePort;
import com.nexum.backend.services.freelancer.interfaces.FreelancerServicePort;
import com.nexum.backend.services.shared.user.Interfaces.UserServicePort;

import java.util.Collection;
import java.util.Optional;

public class CertificacaoService implements CertificacaoServicePort {

    private final SpringCertificacaoRepository springCertificacaoRepository;
    private final FreelancerServicePort freelancerServicePort;
    private final UserServicePort userServicePort;

    public CertificacaoService(
            SpringCertificacaoRepository springCertificacaoRepository,
            FreelancerServicePort freelancerServicePort,
            UserServicePort userServicePort
    ) {
        this.springCertificacaoRepository = springCertificacaoRepository;
        this.freelancerServicePort = freelancerServicePort;
        this.userServicePort = userServicePort;
    }

    @Override
    public CertificacaoDTO create(CertificacaoDTOCreateRequest request, Long id_freelancer) {
        this.userServicePort.existsById(id_freelancer);

        CertificacaoEntity certificacao = new CertificacaoEntity(
                request.getCurso(),
                request.getInstituicao(),
                request.getEstado(),
                request.getCidade(),
                request.getCertificacao_url(),
                new FreelancerEntity(id_freelancer)
        );

        if (certificacao == null) {
            throw new IllegalArgumentException("Erro ao criar certificação");
        }

        return CertificacaoDTOMapper
                .toCertificacaoDTOMapper(
                        this.springCertificacaoRepository.save(certificacao)
                );
    }

    @Override
    public CertificacaoDTO update(CertificacaoDTOUpdateRequest request, Long id_certificacao) {
        Optional<CertificacaoEntity> certificacao = springCertificacaoRepository.findById(id_certificacao);

        if (!certificacao.isPresent()) {
            throw new IllegalArgumentException("ID Certificacão invalido");
        }

        certificacao.get().update(
                request.getCurso(),
                request.getInstituicao(),
                request.getEstado(),
                request.getCidade(),
                request.getCertificacao_url()
        );

        return CertificacaoDTOMapper.toCertificacaoDTOMapper(
                springCertificacaoRepository.save(certificacao.get())
        );
    }

    @Override
    public Collection<CertificacaoDTO> listByFreelancerId(Long id_freelancer) {
        userServicePort.existsById(id_freelancer);

        return CertificacaoDTOMapper.toCollectionCertificacaoDTO(
                springCertificacaoRepository.findByFreelancerId(id_freelancer)
        );
    }

    @Override
    public CertificacaoDTO findById(Long id_certificacao) {
        this.existsById(id_certificacao);

        return CertificacaoDTOMapper.toCertificacaoDTOMapper(
                springCertificacaoRepository.findById(id_certificacao).get()
        );

    }

    @Override
    public Boolean existsById(Long id_certificacao) {
        Boolean isValidCertificaoId = springCertificacaoRepository.existsById(id_certificacao);

        if (!isValidCertificaoId) {
            throw new IllegalArgumentException("id certificacao não existe");
        }

        return isValidCertificaoId;
    }


}
