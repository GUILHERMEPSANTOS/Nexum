package com.nexum.backend.controller.admin;

import com.nexum.backend.domain.controle.acesso.UserEntity;
import com.nexum.backend.dto.freelancer.FreelancerDTO;
import com.nexum.backend.services.admin.interfaces.AdminServicePort;

import com.nexum.backend.services.freelancer.interfaces.FreelancerServicePort;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("api/v1/admin")
@CrossOrigin(origins = "http://nexum.hopto.org:8000")
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
    @CrossOrigin(origins = "*")
    @GetMapping("/exportacao-txt")
    public ResponseEntity importacao() {
        Collection<UserEntity> lista = adminServicePort.listAll();
        adminServicePort.gravaArquivoTxt(lista, "ListaUsuariosNexum.txt");
        return ResponseEntity.status(200).build();
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/importacao-txt/{nomeArq}")
    public ResponseEntity importacao(@PathVariable String nomeArq) {
     adminServicePort.leArquivoTxt(""+nomeArq);

     return ResponseEntity.status(200).build();
    }

}
