package com.nexum.backend.services.shered.interfaces;

import com.nexum.backend.dto.shared.UserDTO;

public interface UserServicePort {
     UserDTO loadUserInformation(Long idUser);
}
