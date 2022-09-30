package com.nexum.web.api.controle.acesso;

import com.nexum.dtos.controle.acesso.UserDTO;
import com.nexum.interfaces.controle.acesso.UserServicePort;
import com.nexum.validation.DomainExceptionValidation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/controle-acesso")
public class ControleAcessoController {
    private final UserServicePort userServicePort;

    public ControleAcessoController(UserServicePort userServicePort) {
        this.userServicePort = userServicePort;
    }

    @GetMapping
    public String teste(){
        return "Aqui";
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
