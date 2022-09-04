package nexum.springboot.controle.acesso.controller;

import nexum.springboot.controle.acesso.dto.UserLoginDTO;
import nexum.springboot.controle.acesso.service.ControleAcessoService;

import org.springframework.beans.factory.annotation.Autowired;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api/v1/controle-acesso")
@AllArgsConstructor
public class ControleAcessoController {
    @Autowired
    private final ControleAcessoService controleAcessoService;

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody UserLoginDTO userLoginDTO) {
        return ResponseEntity.ok(controleAcessoService.singIn(userLoginDTO));
    }
}
