package com.nexum.backend.controller.controle.acesso;

import com.nexum.backend.dto.controle.acesso.UserDTO;
import com.nexum.backend.services.controle.acesso.UserServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/controle-acesso")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ControleAcessoController {
    private final UserServiceImp userServicePort;

    public ControleAcessoController(UserServiceImp userServicePort) {
        this.userServicePort = userServicePort;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> lits(){
        return ResponseEntity.ok().body(userServicePort.list());
    }

    @PostMapping("create-account/contratante")
    public ResponseEntity createContratante(@RequestBody UserDTO userDTO) {
        userServicePort.createContratante(userDTO);

        return new ResponseEntity("User Created", HttpStatus.OK);
    }
    @PostMapping("create-account/freelancer")
    public ResponseEntity createFreelancer(@RequestBody UserDTO userDTO) {
        userServicePort.createFreelancer(userDTO);

        return new ResponseEntity("User Created", HttpStatus.OK);
    }

}
