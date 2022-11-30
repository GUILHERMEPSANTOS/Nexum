package com.nexum.backend.controller.admin;

import com.nexum.backend.services.shared.user.Interfaces.UserServicePort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/dashboard")
public class DashboardController {

    private final UserServicePort userServicePort;

    public DashboardController(UserServicePort userServicePort) {
        this.userServicePort = userServicePort;
    }

    @GetMapping("count-freelancers")
    public ResponseEntity<Integer> countNumberFreelancers() {
        return ResponseEntity.status(200).body(userServicePort.countNumberFreelancers());
    }

    @GetMapping("count-contratantes")
    public ResponseEntity<Integer> countNumberContratantes() {
        return ResponseEntity.status(200).body(userServicePort.countNumberContratantes());
    }
}