package com.nexum.backend.controller.shared.social;


import com.nexum.backend.mappers.shared.social.request.GetlistSocialNetworksByUserQueryMapper;
import com.nexum.backend.mappers.shared.social.shared.social.SocialDTO;
import com.nexum.backend.mappers.shared.social.shared.social.request.GetlistSocialNetworksByUserQuery;
import com.nexum.backend.services.shared.social.interfaces.SocialUserServicePort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("api/v1/social-user/{id_user}")
public class SocialUserController {

    private final SocialUserServicePort socialUserServicePort;

    public SocialUserController(SocialUserServicePort socialUserServicePort) {
        this.socialUserServicePort = socialUserServicePort;
    }

    @GetMapping
    public ResponseEntity<Collection<GetlistSocialNetworksByUserQuery>> listSocialNetworksByUserId(
            @PathVariable Long id_user
    ) {
        return ResponseEntity.status(200).body(socialUserServicePort.listSocialNetworksByUser(id_user));
    }
}
