package com.nexum.backend.repositories.shared.acesso.interfaces;


import com.nexum.backend.dto.controle.acesso.UserSignInDTO;
import com.nexum.backend.dto.controle.acesso.UserSignOutDTO;
import com.nexum.backend.mappers.shared.social.shared.UserDTO;

public interface ControleAcessoServicePort {
    UserDTO signIn(UserSignInDTO userSignInDTO);
    UserDTO signOut(UserSignOutDTO userSignOutDTO);
}
