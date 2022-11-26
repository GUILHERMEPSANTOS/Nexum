package com.nexum.backend.services.shared.controle.acesso;

import com.nexum.backend.domain.controle.acesso.UserEntity;
import com.nexum.backend.controller.embargo.dto.controle.acesso.UserSignInDTO;
import com.nexum.backend.controller.embargo.dto.controle.acesso.UserSignOutDTO;
import com.nexum.backend.mappers.shared.UserDTOMapper;
import com.nexum.backend.controller.embargo.dto.shared.UserDTO;

import com.nexum.backend.repositories.shared.controle.acesso.SpringUserRepository;
import com.nexum.backend.services.shared.controle.acesso.interfaces.ControleAcessoServicePort;

import java.util.Optional;

public class ControleAcessoService implements ControleAcessoServicePort {
    private final SpringUserRepository springUserRepository;

    public ControleAcessoService(SpringUserRepository springUserRepository) {
        this.springUserRepository = springUserRepository;
    }
    @Override
    public UserDTO signIn(UserSignInDTO userSignInDTO) {
        Optional<UserEntity> user =
                springUserRepository.findByEmailAndSenha(userSignInDTO.getEmail(), userSignInDTO.getSenha());

        if(user.isPresent()){
            return UserDTOMapper.toUserDTOMapper(user.get());
        }

        return null;
    }

    @Override
    public UserDTO signOut(UserSignOutDTO userSignOutDTO) {
        return new UserDTO();
    }

}
