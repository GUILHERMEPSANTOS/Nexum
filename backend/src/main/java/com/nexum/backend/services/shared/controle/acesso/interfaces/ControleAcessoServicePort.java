package com.nexum.backend.services.shared.controle.acesso.interfaces;


import com.nexum.backend.controller.embargo.dto.controle.acesso.UserSignInDTO;
import com.nexum.backend.controller.embargo.dto.controle.acesso.UserSignOutDTO;
import com.nexum.backend.controller.embargo.dto.shared.UserDTO;

public interface ControleAcessoServicePort {
    UserDTO signIn(UserSignInDTO userSignInDTO);
    UserDTO signOut(UserSignOutDTO userSignOutDTO);
}
