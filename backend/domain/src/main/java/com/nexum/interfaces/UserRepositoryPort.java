package com.nexum.interfaces;

import com.nexum.entities.controle.acesso.User;

import java.util.List;

public interface UserRepositoryPort {
    void createContratante(User user);
    void createFreelancer(User user);
    List<User> list();
}
