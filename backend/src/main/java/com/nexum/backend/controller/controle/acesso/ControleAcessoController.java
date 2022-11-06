package com.nexum.backend.controller.controle.acesso;

import com.nexum.backend.domain.controle.acesso.UserEntity;
import com.nexum.backend.dto.controle.acesso.UserDTO;
import com.nexum.backend.dto.controle.acesso.UserSignInDTO;
import com.nexum.backend.dto.controle.acesso.UserSignOutDTO;
import com.nexum.backend.repositories.controle.acesso.SpringUserRepository;
import com.nexum.backend.services.controle.acesso.ControleAcessoServiceImp;
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
@CrossOrigin(origins = "*")
public class ControleAcessoController {
    private final ControleAcessoServiceImp ControleAcessoServiceImp;
    private final SpringUserRepository userRepository;

    public ControleAcessoController(ControleAcessoServiceImp ControleAcessoServiceImp, SpringUserRepository userRepository) {
        this.ControleAcessoServiceImp = ControleAcessoServiceImp;
        this.userRepository = userRepository;
    }

    @GetMapping
    public ResponseEntity<List<UserEntity>> lits() {
        return ResponseEntity.ok().body(ControleAcessoServiceImp.list());
    }

    @PostMapping("create-account/contratante")
    public ResponseEntity createContratante(@RequestBody UserDTO userDTO) {
        ControleAcessoServiceImp.createContratante(userDTO);

        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping("create-account/freelancer")
    public ResponseEntity createFreelancer(@RequestBody UserDTO userDTO) {
        ControleAcessoServiceImp.createFreelancer(userDTO);

        return new ResponseEntity(HttpStatus.CREATED);
    }


    @PostMapping("sign-in")
    public ResponseEntity<UserDTO> SignIn(@RequestBody UserSignInDTO userSignInDTO) {
        UserDTO userDTO = ControleAcessoServiceImp.signIn(userSignInDTO);

        if (userDTO == null) {
            return ResponseEntity.status(400).build();
        } else {
            return ResponseEntity.status(200).body(userDTO);
        }
    }

    @GetMapping("/downloadCSV")
    public ResponseEntity<Resource> getFileCSV() {
        String filename = "list-Users.csv";
        InputStreamResource file = new InputStreamResource(ControleAcessoServiceImp.load());


        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                .contentType(MediaType.parseMediaType("application/csv"))
                .body(file);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Long id,
                                 @RequestBody UserDTO userDTO) {
        return userRepository.findById(id)
                .map(userEntity -> {
                    userEntity.setNome(userDTO.getNome());
                    userEntity.setEmail(userDTO.getEmail());
                    userEntity.setCelular(userDTO.getCelular());
                    UserEntity updated = userRepository.save(userEntity);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (userRepository.existsById(id)) {
            userRepository.findById(id);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    public ListObj<String> ordenarLista(ListObj<String> listaDesordenada) {
        ListObj<String> listObj = new ListObj<>(listaDesordenada.getTamanho());

        return (ListObj<String>) listObj.selectionSort(listaDesordenada);

    }
    @PostMapping("sign-out")
    public ResponseEntity singOut(@RequestBody UserSignOutDTO userSignOutDTO) {
        UserDTO userDTO = ControleAcessoServiceImp.signOut(userSignOutDTO);

        if (userDTO == null){
            return ResponseEntity.status(400).build();
        }

        return ResponseEntity.status(200).body(userDTO);
    }


    @GetMapping("/ordenacao")
    public ResponseEntity<ListObj<String>> ordenacaoSelectionSort() {
        List<UserEntity> userEntities = userRepository.findAll();
        ListObj<String> listaNomes = new ListObj<>(userEntities.size());
        for (int i = 0; i < userEntities.size(); i++) {
            listaNomes.adiciona(userEntities.get(i).getNome());
        }
        if (userEntities.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(ordenarLista(listaNomes));
    }
}
