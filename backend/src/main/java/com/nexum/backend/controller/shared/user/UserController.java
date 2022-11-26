package com.nexum.backend.controller.shared.user;


import com.nexum.backend.services.shared.user.Interfaces.UserServicePort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    private final UserServicePort userServicePort;

    public UserController(UserServicePort userServicePort) {
        this.userServicePort = userServicePort;
    }

    @PostMapping("{id_user}/habilidade/{id_habilidade}")
    public ResponseEntity AddHabilidade(
            @PathVariable Long id_habilidade,
            @PathVariable Long id_user
    ) {
//        userServicePort.AddHabilidade(id_habilidade, id_user);

        return ResponseEntity.status(200).build();
    }
}
