package com.nexum.backend.services.controle.acesso;

import com.nexum.backend.domain.controle.acesso.ContratanteEntity;
import com.nexum.backend.domain.controle.acesso.FreelancerEntity;
import com.nexum.backend.domain.controle.acesso.RoleEntity;
import com.nexum.backend.domain.controle.acesso.UserEntity;
import com.nexum.backend.dto.controle.acesso.UserDTO;
import com.nexum.backend.dto.controle.acesso.UserSignInDTO;
import com.nexum.backend.dto.controle.acesso.UserSignOutDTO;
import com.nexum.backend.enums.RoleName;
import com.nexum.backend.helperFile.CSVhelper;
import com.nexum.backend.repositories.controle.acesso.SpringRoleRepository;
import com.nexum.backend.repositories.controle.acesso.SpringUserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ControleAcessoServiceImp {
    private final SpringUserRepository springUserRepository;
    private final SpringRoleRepository springRoleRepository;

    public ControleAcessoServiceImp(SpringUserRepository springUserRepository, SpringRoleRepository springRoleRepository) {
        this.springUserRepository = springUserRepository;
        this.springRoleRepository = springRoleRepository;
    }

    public void createContratante(UserDTO userDTO) {
        UserEntity user = new ContratanteEntity(userDTO);

        RoleEntity role = springRoleRepository.findByRoleName(RoleName.ROLE_CONTRATANTE);

        user.getRoles().add(role);

        springUserRepository.save(user);
    }


    public void createFreelancer(UserDTO userDTO) {
        UserEntity user = new FreelancerEntity(userDTO);

        RoleEntity role = springRoleRepository.findByRoleName(RoleName.ROLE_FREELANCER);

        user.getRoles().add(role);

        springUserRepository.save(user);
    }

    public UserDTO signIn(UserSignInDTO userSignInDTO) {
        Optional<UserEntity> userEntity = springUserRepository
                .findByEmailAndSenha(userSignInDTO.getEmail(), userSignInDTO.getSenha());

        if (userEntity.isPresent()) {
            userEntity.get().setLogged(true);
            return new UserDTO((FreelancerEntity) springUserRepository.save(userEntity.get()));
        }
        return null;
    }

    public UserDTO signOut(UserSignOutDTO userSignOutDTO) {
        Optional<UserEntity> userEntity = springUserRepository
                .findByEmail(userSignOutDTO.email);

        if (userEntity.isPresent()) {
            userEntity.get().setLogged(false);
            return new UserDTO((FreelancerEntity) springUserRepository.save(userEntity.get()));
        }
        return null;
    }

    public List<UserEntity> list() {
        List<UserEntity> users = springUserRepository.findAll();
        return users;
    }

    public ByteArrayInputStream load() {
        List<UserEntity> userEntitys = springUserRepository.findAll();

        ByteArrayInputStream in = CSVhelper.userToCSV(userEntitys);
        return in;
    }


}
