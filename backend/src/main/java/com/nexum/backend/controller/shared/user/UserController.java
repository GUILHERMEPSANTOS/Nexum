package com.nexum.backend.controller.shared.user;


import com.nexum.backend.dto.shared.user.request.UserSobreUpdateRequest;
import com.nexum.backend.services.shared.user.Interfaces.UserServicePort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
@CrossOrigin(origins =  {"http://nexum.hopto.org:8000", "http://localhost"})
public class UserController {
    private final UserServicePort userServicePort;

    public UserController(UserServicePort userServicePort) {
        this.userServicePort = userServicePort;
    }

    @PutMapping("update-sobre")
    public ResponseEntity updateAboutUser(@RequestBody UserSobreUpdateRequest request) {
        userServicePort.updateAboutUser(request);

        return ResponseEntity.status(200).build();
    }

    @GetMapping("{id_user}/sobre")
    public ResponseEntity<String> getAboutUser(@PathVariable Long id_user) {
        return ResponseEntity.status(200).body(userServicePort.getAboutUser(id_user));
    }
}
