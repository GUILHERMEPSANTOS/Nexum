package com.nexum.backend.controller.shared.controle.acesso;

import com.nexum.backend.controller.shared.PilhaObj;
import com.nexum.backend.dto.controle.acesso.UserSignInDTO;
import com.nexum.backend.dto.controle.acesso.UserSignOutDTO;
import com.nexum.backend.dto.shared.user.UserDTO;
import com.nexum.backend.services.shared.controle.acesso.interfaces.ControleAcessoServicePort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/controle-acesso")
@CrossOrigin(origins =  {"http://nexum.hopto.org:8000", "http://localhost"})
public class ControleAcessoController {

        private PilhaObj pilhaObj = new PilhaObj<>(100);
    private final ControleAcessoServicePort controleAcessoServicePort;

    public ControleAcessoController(ControleAcessoServicePort controleAcessoServicePort) {
        this.controleAcessoServicePort = controleAcessoServicePort;
    }

    @PostMapping("sign-in")
    public ResponseEntity<UserDTO> signIn(@RequestBody UserSignInDTO userSignInDTO) {
        UserDTO userDTO = controleAcessoServicePort.signIn(userSignInDTO);

        if (userDTO == null) {
            return ResponseEntity.status(400).build();
        } else {
            pilhaObj.push(userSignInDTO);
            return ResponseEntity.status(200).body(userDTO);
        }
    }

    @PostMapping("sign-out")
    public ResponseEntity singOut(@RequestBody UserSignOutDTO userSignOutDTO) {
        UserDTO userDTO = controleAcessoServicePort.signOut(userSignOutDTO);

        if (userDTO == null) {
            return ResponseEntity.status(400).build();
        }
        pilhaObj.pop();
        return ResponseEntity.status(200).body(userDTO);
    }

    @GetMapping("PilhaObj")
    public ResponseEntity<PilhaObj> exibeObj() {
        System.out.println(pilhaObj);
        return ResponseEntity.status(200).body(pilhaObj);
    }
}
