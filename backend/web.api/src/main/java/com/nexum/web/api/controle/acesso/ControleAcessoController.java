package com.nexum.web.api.controle.acesso;

import com.nexum.dtos.controle.acesso.UserDTO;
import com.nexum.interfaces.controle.acesso.UserServicePort;
import com.nexum.validation.DomainExceptionValidation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/controle-acesso")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ControleAcessoController {
    private final UserServicePort userServicePort;

    public ControleAcessoController(UserServicePort userServicePort) {
        this.userServicePort = userServicePort;
    }

    @PreAuthorize("hasRole('ROLE_CONTRATANTE')")
    @GetMapping
    public ResponseEntity<List<UserDTO>> lits(){
        return ResponseEntity.ok().body(userServicePort.list());
    }

    @PostMapping("create-account/contratante")
    public ResponseEntity createContratante(@RequestBody UserDTO userDTO) throws DomainExceptionValidation {
        userServicePort.createContratante(userDTO);

        return new ResponseEntity("User Created", HttpStatus.OK);
    }
    @PostMapping("create-account/freelancer")
    public ResponseEntity createFreelancer(@RequestBody UserDTO userDTO) throws DomainExceptionValidation {
        userServicePort.createFreelancer(userDTO);

        return new ResponseEntity("User Created", HttpStatus.OK);
    }

}
