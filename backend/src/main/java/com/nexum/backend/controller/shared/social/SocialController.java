package com.nexum.backend.controller.shared.social;

import com.nexum.backend.dto.shared.social.SocialDTO;
import com.nexum.backend.services.shared.social.interfaces.SocialServicePort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("api/v1/social")
@CrossOrigin(origins = "https://nexum.hopto.org")
public class SocialController {

    private final SocialServicePort socialServicePort;

    public SocialController(SocialServicePort socialServicePort) {
        this.socialServicePort = socialServicePort;
    }

    @GetMapping
    public ResponseEntity<Collection<SocialDTO>> listSocialNetworks() {
        return ResponseEntity.status(200).body(socialServicePort.listSocialNetworks());
    }
}
