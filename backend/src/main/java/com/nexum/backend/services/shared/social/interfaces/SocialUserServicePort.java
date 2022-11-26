package com.nexum.backend.services.shared.social.interfaces;

import com.nexum.backend.dto.shared.social.request.SocialUserCreateRequest;
import com.nexum.backend.dto.shared.social.response.GetlistSocialNetworksByUserQuery;

import java.util.Collection;

public interface SocialUserServicePort {
    void addOrUpdateSocialToUser(Long id_user, Collection<SocialUserCreateRequest> request);

    Collection<GetlistSocialNetworksByUserQuery> listSocialNetworksByUser(Long id_user);
}
