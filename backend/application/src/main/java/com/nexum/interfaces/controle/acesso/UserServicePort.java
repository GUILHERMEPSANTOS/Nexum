package com.nexum.interfaces.controle.acesso;

import com.nexum.dtos.controle.acesso.UserDTO;
import com.nexum.validation.DomainExceptionValidation;

import java.util.List;

public interface UserServicePort {
    void createContratante(UserDTO user) throws DomainExceptionValidation;
    void createFreelancer(UserDTO user) throws DomainExceptionValidation;
    List<UserDTO> list();
}
