package com.nexum.backend.controller.shared.controle.acesso;

import com.nexum.backend.controller.embargo.dto.controle.acesso.UserSignInDTO;
import com.nexum.backend.controller.embargo.dto.controle.acesso.UserSignOutDTO;
import com.nexum.backend.controller.embargo.dto.shared.UserDTO;
import com.nexum.backend.services.shared.controle.acesso.interfaces.ControleAcessoServicePort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/controle-acesso")
@CrossOrigin(origins = "*")
public class ControleAcessoController {
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
            return ResponseEntity.status(200).body(userDTO);
        }
    }

    @PostMapping("sign-out")
    public ResponseEntity singOut(@RequestBody UserSignOutDTO userSignOutDTO) {
        UserDTO userDTO = controleAcessoServicePort.signOut(userSignOutDTO);

        if (userDTO == null) {
            return ResponseEntity.status(400).build();
        }

        return ResponseEntity.status(200).body(userDTO);
    }


// TODO: 12/11/2022  analisar em qual contexto esse metodo se encaixa
//    public ListObj<String> ordenarLista(ListObj<String> listaDesordenada) {
//        ListObj<String> listObj = new ListObj<>(listaDesordenada.getTamanho());
//
//        return (ListObj<String>) listObj.selectionSort(listaDesordenada);
//
//    }
//

// TODO: 12/11/2022 -(iuri) metodo se encaixa no contexto da shared porem não no controle de acesso
//    @GetMapping("/ordenacao")
//    public ResponseEntity<ListObj<String>> ordenacaoSelectionSort() {
//        List<UserEntity> userEntities = userRepository.findAll();
//        ListObj<String> listaNomes = new ListObj<>(userEntities.size());
//        for (int i = 0; i < userEntities.size(); i++) {
//            listaNomes.adiciona(userEntities.get(i).getNome());
//        }
//        if (userEntities.isEmpty()) {
//            return ResponseEntity.status(204).build();
//        }
//        return ResponseEntity.status(200).body(ordenarLista(listaNomes));
//    }
}
