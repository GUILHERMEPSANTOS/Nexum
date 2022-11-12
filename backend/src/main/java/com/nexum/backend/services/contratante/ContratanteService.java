package com.nexum.backend.services.contratante;

import com.nexum.backend.domain.controle.acesso.ContratanteEntity;
import com.nexum.backend.domain.controle.acesso.RoleEntity;

import com.nexum.backend.dto.contratante.ContratanteDTO;
import com.nexum.backend.dto.mappers.contratante.ContratanteDTOMapper;

import com.nexum.backend.enums.RoleName;

import com.nexum.backend.repositories.contratante.SpringContratanteRepository;
import com.nexum.backend.repositories.controle.acesso.SpringRoleRepository;

import com.nexum.backend.services.contratante.interfaces.ContratanteServicePort;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

public class ContratanteService implements ContratanteServicePort {
    private SpringContratanteRepository springContratanteRepository;
    private SpringRoleRepository springRoleRepository;

    public ContratanteService(
            SpringContratanteRepository springContratanteRepository,
            SpringRoleRepository springRoleRepository
    ) {
        this.springContratanteRepository = springContratanteRepository;
        this.springRoleRepository = springRoleRepository;
    }

    @Override
    public void create(ContratanteDTO contratante) {
        ContratanteEntity user = new ContratanteEntity(
                contratante.getNome(),
                contratante.getEmail(),
                contratante.getSenha(),
                contratante.getCelular()
        );

        RoleEntity role = springRoleRepository.findByRoleName(RoleName.ROLE_CONTRATANTE);

        user.getRoles().add(role);

        springContratanteRepository.save(user);
    }

    @Override
    public Collection<ContratanteDTO> listAll() {
        return springContratanteRepository
                .findAll()
                .stream()
                .map(contratante -> ContratanteDTOMapper.toContratanteDTO(contratante))
                .collect(Collectors.toList());
    }

    @Override
    public ContratanteDTO getById(Long id) {
        Optional<ContratanteEntity> contratanteEntity = springContratanteRepository.findById(id);

        if (contratanteEntity.isPresent()) {
            return ContratanteDTOMapper.toContratanteDTO(contratanteEntity.get());
        }

        return null;
    }
}
