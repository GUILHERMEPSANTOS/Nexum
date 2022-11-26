package com.nexum.backend.mappers.shared.social;

import com.nexum.backend.domain.social.SocialEntity;
import com.nexum.backend.dto.shared.social.SocialDTO;

public class SocialDTOMapper {
    public static SocialDTO toSocialDTO(SocialEntity socialEntity) {
        return new SocialDTO(
                socialEntity.getId_social(),
                socialEntity.getNome()
        );
    }


}
