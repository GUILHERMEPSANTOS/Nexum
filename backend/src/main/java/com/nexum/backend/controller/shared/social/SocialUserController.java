package com.nexum.backend.controller.shared.social;


import com.nexum.backend.dto.shared.social.request.SocialUserCreateRequest;
import com.nexum.backend.dto.shared.social.response.GetlistSocialNetworksByUserQuery;
import com.nexum.backend.services.shared.social.interfaces.SocialUserServicePort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity addOrUpdateSocialToUser(
            @PathVariable Long id_user,
            @RequestBody Collection<SocialUserCreateRequest> request
    ) {
        socialUserServicePort.addOrUpdateSocialToUser(id_user, request);

        return ResponseEntity.status(200).build();
    }
}
