package com.nexum.backend.services.shared.social.interfaces;

import com.nexum.backend.mappers.shared.social.shared.social.SocialDTO;

import java.util.Collection;

public interface SocialServicePort {
    Collection<SocialDTO> listSocialNetworks();
}
