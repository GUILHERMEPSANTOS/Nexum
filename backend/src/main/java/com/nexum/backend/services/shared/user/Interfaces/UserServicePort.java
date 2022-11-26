package com.nexum.backend.services.shared.user.Interfaces;

public interface UserServicePort {
    //    void AddHabilidade(Long id_habilidade, Long id_user);
    Boolean existsById(Long id_user);
}
