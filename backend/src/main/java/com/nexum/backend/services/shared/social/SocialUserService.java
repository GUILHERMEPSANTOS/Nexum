package com.nexum.backend.services.shared.social;

import com.nexum.backend.domain.social.SocialUserEntity;
import com.nexum.backend.mappers.shared.social.request.GetlistSocialNetworksByUserQueryMapper;
import com.nexum.backend.mappers.shared.social.shared.social.request.GetlistSocialNetworksByUserQuery;
import com.nexum.backend.repositories.shared.social.SpringSocialUserRepository;
import com.nexum.backend.services.shared.social.interfaces.SocialUserServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;

public class SocialUserService implements SocialUserServicePort {

    private final SpringSocialUserRepository springSocialUserRepository;

    public SocialUserService(SpringSocialUserRepository springSocialUserRepository) {
        this.springSocialUserRepository = springSocialUserRepository;
    }

    @Override
    public void addSocialToUser(Long id_user) {

    }

    @Override
    public Collection<GetlistSocialNetworksByUserQuery> listSocialNetworksByUser(Long id_user) {
        Collection<SocialUserEntity> socialsUser =
                springSocialUserRepository.listSocialNetworksByUser(id_user);

        if (socialsUser.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NO_CONTENT, "Nenhuma rede social para o usuário"
            );
        }

        return GetlistSocialNetworksByUserQueryMapper
                .toCollectionGetlistSocialNetworksByUserQuery(socialsUser);
    }
}
