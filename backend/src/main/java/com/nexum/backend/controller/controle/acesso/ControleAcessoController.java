package com.nexum.backend.controller.controle.acesso;

import com.nexum.backend.domain.controle.acesso.UserEntity;
import com.nexum.backend.dto.controle.acesso.UserDTO;
import com.nexum.backend.dto.controle.acesso.UserSignInDTO;
import com.nexum.backend.repositories.controle.acesso.SpringUserRepository;
import com.nexum.backend.services.controle.acesso.UserServiceImp;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/controle-acesso")
public class ControleAcessoController {
    private final UserServiceImp userServicePort;
    private final SpringUserRepository userRepository;

    public ControleAcessoController(UserServiceImp userServicePort, SpringUserRepository userRepository) {
        this.userServicePort = userServicePort;
        this.userRepository = userRepository;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> lits() {
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


    @PostMapping("sign-in")
    public ResponseEntity<UserDTO> SignIn(@RequestBody UserSignInDTO userSignInDTO) {
        UserDTO userDTO = userServicePort.SignIn(userSignInDTO);

        if (userDTO == null) {
            return ResponseEntity.status(400).build();
        } else {
            return ResponseEntity.status(200).body(userDTO);
        }
    }

    @GetMapping("/download")
    public ResponseEntity<Resource> getFile() {
        String filename = "list-Users.csv";
        InputStreamResource file = new InputStreamResource(userServicePort.load());


        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                .contentType(MediaType.parseMediaType("application/csv"))
                .body(file);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable("id") long id,
                                 @RequestBody UserDTO userDTO) {
        return userRepository.findById(id)
                .map(userEntity -> {
                    userEntity.setNome(userDTO.getNome());
                    userEntity.setEmail(userDTO.getEmail());
                    userEntity.setProfissao(userDTO.getProfissao());
                    userEntity.setCpf(userDTO.getCpf());
                    UserEntity updated = userRepository.save(userEntity);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }


}
