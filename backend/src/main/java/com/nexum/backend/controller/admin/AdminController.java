package com.nexum.backend.controller.admin;

import com.nexum.backend.services.admin.interfaces.AdminServicePort;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/admin")
public class AdminController {
    private AdminServicePort adminServicePort;

    public AdminController(AdminServicePort adminServicePort) {
        this.adminServicePort = adminServicePort;
    }

    @GetMapping("/download-csv")
    public ResponseEntity<Resource> getFileCSV() {

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + "list-Users.csv")
                .contentType(MediaType.parseMediaType("application/csv"))
                .body(adminServicePort.load());
    }
}
