package com.nexum.backend.services.shared.social.interfaces;

import com.nexum.backend.dto.shared.social.SocialDTO;

import java.util.Collection;

public interface SocialServicePort {
    Collection<SocialDTO> listSocialNetworks();
}
