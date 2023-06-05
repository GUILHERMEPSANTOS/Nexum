package com.nexum.backend.controller.admin;

import com.nexum.backend.services.shared.user.Interfaces.UserServicePort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/dashboard")
@CrossOrigin(origins =  {"http://nexum.hopto.org:8000", "http://localhost"})
public class DashboardController {

    private final UserServicePort userServicePort;

    public DashboardController(UserServicePort userServicePort) {
        this.userServicePort = userServicePort;
    }
    @CrossOrigin(origins = "*")
    @GetMapping("count-freelancers")
    public ResponseEntity<Integer> countNumberFreelancers() {
        return ResponseEntity.status(200).body(userServicePort.countNumberFreelancers());
    }
    @CrossOrigin(origins = "*")
    @GetMapping("count-contratantes")
    public ResponseEntity<Integer> countNumberContratantes() {
        return ResponseEntity.status(200).body(userServicePort.countNumberContratantes());
    }
}