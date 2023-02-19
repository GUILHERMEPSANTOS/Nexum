package com.nexum.backend.services.shared.photo.interfaces;

import com.nexum.backend.dto.shared.photo.ImageDTO;

public interface ImageServicePort {
    void addOrUpdate(ImageDTO imageDTO);
    ImageDTO getProfileImage(Long userId);
}
