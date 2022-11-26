package com.nexum.backend.mappers.shared.social.request;

import com.nexum.backend.domain.social.SocialUserEntity;
import com.nexum.backend.dto.shared.social.response.GetlistSocialNetworksByUserQuery;

import java.util.Collection;
import java.util.stream.Collectors;

public class GetlistSocialNetworksByUserQueryMapper {
    private static GetlistSocialNetworksByUserQuery toGetlistSocialNetworksByUserQuery(
            SocialUserEntity socialUserEntity
    ) {
        return new GetlistSocialNetworksByUserQuery(
                socialUserEntity.getSocial().getId_social(),
                socialUserEntity.getSocial().getNome(),
                socialUserEntity.getUser_url()
        );
    }

    public static Collection<GetlistSocialNetworksByUserQuery> toCollectionGetlistSocialNetworksByUserQuery(
            Collection<SocialUserEntity> socialUserEntities
    ) {

        return socialUserEntities
                .stream()
                .map(GetlistSocialNetworksByUserQueryMapper::toGetlistSocialNetworksByUserQuery)
                .collect(Collectors.toList());
    }
}
