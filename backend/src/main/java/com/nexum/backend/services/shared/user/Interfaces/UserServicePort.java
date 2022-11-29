package com.nexum.backend.services.shared.user.Interfaces;

import com.nexum.backend.dto.shared.user.UserDTO;
import com.nexum.backend.dto.shared.user.request.UserSobreUpdateRequest;

public interface UserServicePort {
    Boolean existsById(Long id_user);

    String getAboutUser(Long id_user);

    void updateAboutUser(UserSobreUpdateRequest request);
}
