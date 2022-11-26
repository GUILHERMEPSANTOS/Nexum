package com.nexum.backend.mappers.shared.social;

import com.nexum.backend.domain.social.SocialUserEntity;
import com.nexum.backend.mappers.shared.social.shared.social.SocialUserDTO;

import java.util.Collection;
import java.util.stream.Collectors;

public class SocialUserDTOMapper {
    public static SocialUserDTO toSocialUserDTO(SocialUserEntity socialUserEntity) {
        return new SocialUserDTO(
                socialUserEntity.getId_social_user(),
                SocialDTOMapper.toSocialDTO(socialUserEntity.getSocial()),
                socialUserEntity.getUser_url()
        );
    }

    public static Collection<SocialUserDTO> toCollectionSocialUserDTO(
            Collection<SocialUserEntity> socialUserEntities
    ) {
        return socialUserEntities
                .stream()
                .map(socialUserEntity -> toSocialUserDTO(socialUserEntity))
                .collect(Collectors.toList());
    }

}
