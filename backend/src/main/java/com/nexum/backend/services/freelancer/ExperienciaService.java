package com.nexum.backend.services.freelancer;

import com.nexum.backend.domain.controle.acesso.FreelancerEntity;
import com.nexum.backend.domain.experiencia.ExperienciaEntity;
import com.nexum.backend.dto.freelancer.experiencia.ExperienciaDTO;
import com.nexum.backend.dto.freelancer.experiencia.request.ExperienciaDTOCreateRequest;
import com.nexum.backend.dto.freelancer.experiencia.request.ExperienciaDTOUpdateRequest;
import com.nexum.backend.mappers.freelancer.experiencia.ExperienciaDTOMapper;
import com.nexum.backend.domain.certificacao.freelancer.experiencia.SpringExperienciaRepository;
import com.nexum.backend.services.freelancer.interfaces.ExperienciaServicePort;
import com.nexum.backend.services.freelancer.interfaces.FreelancerServicePort;
import com.nexum.backend.services.shared.user.Interfaces.UserServicePort;

import java.util.Collection;
import java.util.Optional;

public class ExperienciaService implements ExperienciaServicePort {
    private final FreelancerServicePort freelancerServicePort;
    private final SpringExperienciaRepository springExperienciaRepository;
    private final UserServicePort userServicePort;

    public ExperienciaService(
            FreelancerServicePort freelancerServicePort,
            SpringExperienciaRepository springExperienciaRepository,
            UserServicePort userServicePort
    ) {
        this.freelancerServicePort = freelancerServicePort;
        this.springExperienciaRepository = springExperienciaRepository;
        this.userServicePort = userServicePort;
    }

    @Override
    public ExperienciaDTO create(
            ExperienciaDTOCreateRequest request,
            Long id_freelancer
    ) {
        userServicePort.existsById(id_freelancer);

        ExperienciaEntity experiencia = new ExperienciaEntity(
                request.getCargo(),
                request.getEmpresa(),
                request.getCidade(),
                request.getEstado(),
                request.getSobre(),
                request.getData_inicial(),
                request.getData_final(),
                new FreelancerEntity(id_freelancer)
        );

        if (experiencia == null) {
            throw new IllegalArgumentException("Erro ao criar Formação");
        }

        return ExperienciaDTOMapper
                .toExperienciaDTOMapper(
                        springExperienciaRepository.save(experiencia)
                );
    }

    @Override
    public ExperienciaDTO update(
            ExperienciaDTOUpdateRequest request,
            Long id_experiencia
    ) {
        Optional<ExperienciaEntity> experiencia = springExperienciaRepository.findById(id_experiencia);

        if (!experiencia.isPresent()) {
            throw new IllegalArgumentException("ID formação invalido");
        }

        experiencia.get().update(
                request.getCargo(),
                request.getEmpresa(),
                request.getCidade(),
                request.getEstado(),
                request.getSobre(),
                request.getData_inicial(),
                request.getData_final()
        );

        return ExperienciaDTOMapper
                .toExperienciaDTOMapper(
                        springExperienciaRepository.save(experiencia.get())
                );
    }

    @Override
    public Collection<ExperienciaDTO> listByFreelancerId(Long id_freelancer) {
        userServicePort.existsById(id_freelancer);

        return ExperienciaDTOMapper
                .toCollectionExperienciaDTOMapper(
                        springExperienciaRepository.findByFreelancerId(id_freelancer)
                );
    }

    @Override
    public ExperienciaDTO findById(Long id_experiencia) {
        Optional<ExperienciaEntity> experiencia = springExperienciaRepository.findById(id_experiencia);

        if(!experiencia.isPresent()){
            throw  new IllegalArgumentException("ID experiencia invalido");
        }

        return ExperienciaDTOMapper.toExperienciaDTOMapper(experiencia.get());
    }
}
