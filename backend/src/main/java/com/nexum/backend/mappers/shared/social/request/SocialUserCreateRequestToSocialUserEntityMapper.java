package com.nexum.backend.mappers.shared.social.request;

import com.nexum.backend.domain.controle.acesso.UserEntity;
import com.nexum.backend.domain.social.SocialEntity;
import com.nexum.backend.domain.social.SocialUserEntity;
import com.nexum.backend.dto.shared.social.request.SocialUserCreateRequest;

import java.util.Collection;
import java.util.stream.Collectors;

public class SocialUserCreateRequestToSocialUserEntityMapper {
    private static SocialUserEntity socialUserCreateRequestToSocialUserEntity(
            SocialUserCreateRequest request,
            Long id_user
    ) {
        return new SocialUserEntity(
                new UserEntity(id_user),
                new SocialEntity(request.getId_social()),
                request.getUser_url());
    }

    public static Collection<SocialUserEntity> collectionSocialUserCreateRequestToCollectionSocialUserEntity(
            Collection<SocialUserCreateRequest> request,
            Long id_user
    ) {
        return request
                .stream()
                .map(req -> socialUserCreateRequestToSocialUserEntity(req, id_user))
                .collect(Collectors.toList());
    }
}
