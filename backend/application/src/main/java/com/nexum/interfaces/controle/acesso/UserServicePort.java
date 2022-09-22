package com.nexum.interfaces.controle.acesso;

import com.nexum.dtos.controle.acesso.UserDTO;
import com.nexum.validation.DomainExceptionValidation;

import java.util.List;

public interface UserServicePort {
    void create(UserDTO user) throws DomainExceptionValidation;

    List<UserDTO> list();

    void update(UserDTO user) throws DomainExceptionValidation;
}
