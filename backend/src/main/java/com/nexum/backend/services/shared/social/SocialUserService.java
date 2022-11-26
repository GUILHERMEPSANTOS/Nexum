package com.nexum.backend.services.shared.social;

import com.nexum.backend.domain.controle.acesso.UserEntity;
import com.nexum.backend.domain.social.SocialEntity;
import com.nexum.backend.domain.social.SocialUserEntity;
import com.nexum.backend.dto.shared.social.request.SocialUserCreateRequest;
import com.nexum.backend.mappers.shared.social.request.SocialUserCreateRequestToSocialUserEntityMapper;
import com.nexum.backend.mappers.shared.social.response.GetlistSocialNetworksByUserQueryMapper;
import com.nexum.backend.dto.shared.social.response.GetlistSocialNetworksByUserQuery;
import com.nexum.backend.repositories.shared.social.SpringSocialUserRepository;
import com.nexum.backend.services.shared.social.interfaces.SocialUserServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.stream.Collectors;

public class SocialUserService implements SocialUserServicePort {

    private final SpringSocialUserRepository springSocialUserRepository;

    public SocialUserService(SpringSocialUserRepository springSocialUserRepository) {
        this.springSocialUserRepository = springSocialUserRepository;
    }

    @Override
    public void addOrUpdateSocialToUser(Long id_user, Collection<SocialUserCreateRequest> request) {
        Collection<SocialUserEntity> socialUserEntities =
                SocialUserCreateRequestToSocialUserEntityMapper
                        .collectionSocialUserCreateRequestToCollectionSocialUserEntity(request, id_user);

        socialUserEntities.forEach(socialUserEntity -> {

            if (checkUserAlreadyHasSocialNetworkByIdSocialAndIdUser(
                    socialUserEntity.getUserEntity().getId_usuario(),
                    socialUserEntity.getSocial().getId_social()
            )) {
                updateSocialUser(socialUserEntity);
            } else {
                addSocialToUser(socialUserEntity);
            }
        });
    }

    private void updateSocialUser(SocialUserEntity socialUserEntity) {
        springSocialUserRepository.updateSocialUser(
                socialUserEntity.getUserEntity().getId_usuario(),
                socialUserEntity.getSocial().getId_social(),
                socialUserEntity.getUser_url()
        );
    }

    private void addSocialToUser(SocialUserEntity socialUserEntity) {
        springSocialUserRepository.save(socialUserEntity);
    }

    @Override
    public Collection<GetlistSocialNetworksByUserQuery> listSocialNetworksByUser(Long id_user) {
        Collection<SocialUserEntity> socialsUser =
                springSocialUserRepository.listSocialNetworksByUser(id_user);

        if (socialsUser.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Nenhuma rede social para o usuário");
        }

        return GetlistSocialNetworksByUserQueryMapper
                .toCollectionGetlistSocialNetworksByUserQuery(socialsUser);
    }

    private Boolean checkUserAlreadyHasSocialNetworkByIdSocialAndIdUser(Long id_user, Long id_social) {
        return springSocialUserRepository
                .checkUserAlreadyHasSocialNetworkByIdSocialAndIdUser(id_user, id_social);
    }
}
