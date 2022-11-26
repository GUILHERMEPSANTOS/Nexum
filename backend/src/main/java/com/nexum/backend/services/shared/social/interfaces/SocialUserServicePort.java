package com.nexum.backend.services.shared.social.interfaces;

import com.nexum.backend.mappers.shared.social.shared.social.request.GetlistSocialNetworksByUserQuery;

import java.util.Collection;

public interface SocialUserServicePort {
    void addSocialToUser(Long id_user);

    Collection<GetlistSocialNetworksByUserQuery> listSocialNetworksByUser(Long id_user);
}
