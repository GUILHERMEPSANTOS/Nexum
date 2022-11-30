package com.nexum.backend.services.shared.user;

import com.nexum.backend.dto.shared.user.UserDTO;
import com.nexum.backend.dto.shared.user.request.UserSobreUpdateRequest;
import com.nexum.backend.repositories.shared.controle.acesso.SpringUserRepository;
import com.nexum.backend.services.contratante.interfaces.ContratanteServicePort;
import com.nexum.backend.services.freelancer.interfaces.FreelancerServicePort;
import com.nexum.backend.services.freelancer.interfaces.HabilidadeServicePort;
import com.nexum.backend.services.shared.user.Interfaces.UserServicePort;
import org.springframework.scheduling.annotation.Async;

public class UserService implements UserServicePort {
    private final SpringUserRepository springUserRepository;
    private final FreelancerServicePort freelancerServicePort;
    private final ContratanteServicePort contratanteServicePort;

    public UserService(
            SpringUserRepository springUserRepository,
            FreelancerServicePort freelancerServicePort,
            ContratanteServicePort contratanteServicePort
    ) {
        this.springUserRepository = springUserRepository;
        this.freelancerServicePort = freelancerServicePort;
        this.contratanteServicePort = contratanteServicePort;
    }

    @Override
    public Boolean existsById(Long id_user) {
        Boolean isValidUserId = springUserRepository.existsById(id_user);

        if (!isValidUserId) {
            throw new IllegalArgumentException("ID usuário inválido");
        }

        return isValidUserId;
    }

    @Override
    public String getAboutUser(Long id_user) {
        return springUserRepository.getAboutUser(id_user);
    }

    @Override
    public Integer countNumberFreelancers() {
        return freelancerServicePort.countNumberFreelancers();
    }

    @Override
    public Integer countNumberContratantes() {
        return contratanteServicePort.countNumberContratantes();
    }

    @Override
    public void updateAboutUser(UserSobreUpdateRequest request) {
        this.existsById(request.getId_user());

        springUserRepository.updateAboutUser(request.getSobre(), request.getId_user());
    }
}
