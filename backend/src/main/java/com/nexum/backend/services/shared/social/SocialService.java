package com.nexum.backend.services.shared.social;

import com.nexum.backend.mappers.shared.social.shared.social.SocialDTO;
import com.nexum.backend.mappers.shared.social.SocialDTOMapper;
import com.nexum.backend.repositories.shared.social.SpringSocialRepository;
import com.nexum.backend.services.shared.social.interfaces.SocialServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.stream.Collectors;

public class SocialService implements SocialServicePort {

    private final SpringSocialRepository socialRepository;

    public SocialService(SpringSocialRepository socialRepository) {
        this.socialRepository = socialRepository;
    }

    @Override
    public Collection<SocialDTO> listSocialNetworks() {
        Collection<SocialDTO> socialDTOS = socialRepository
                .findAll()
                .stream()
                .map(SocialDTOMapper::toSocialDTO)
                .collect(Collectors.toList());

        if (socialDTOS.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Nenhuma rede social encontrada");
        }

        return socialDTOS;
    }
}
