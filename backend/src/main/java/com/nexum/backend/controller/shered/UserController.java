package com.nexum.backend.controller.shered;


import com.nexum.backend.dto.shared.UserDTO;
import com.nexum.backend.services.shered.interfaces.UserServicePort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user/{id_user}")
public class UserController {

    private UserServicePort userServicePort;

    public UserController(UserServicePort userServicePort) {
        this.userServicePort = userServicePort;
    }

    @GetMapping("information")
    public ResponseEntity<UserDTO> loadUserInformation(@PathVariable Long id_user) {
        return ResponseEntity.status(200).body(userServicePort.loadUserInformation(id_user));
    }
}
