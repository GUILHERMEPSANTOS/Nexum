package com.nexum.backend.contratante;

import com.nexum.backend.controller.admin.AdminController;
import com.nexum.backend.controller.contratante.ContratanteController;
import com.nexum.backend.dto.contratante.ContratanteDTO;
import com.nexum.backend.repositories.contratante.SpringContratanteRepository;
import com.nexum.backend.repositories.shared.controle.acesso.SpringUserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TesteContratanteController {

    @Autowired
    private ContratanteController controller;

    @MockBean
    private SpringContratanteRepository repository;

    @Test
    @DisplayName("Validar que esta sendo criado um novo Contratante")
    public void validandoQueEstaSendoCriadoContaContratante(){
        when(repository.existsById(anyLong()) && repository.existsById(anyLong()))
                .thenReturn(true);

        ContratanteDTO contratanteDTO = new ContratanteDTO();

        ResponseEntity<ContratanteDTO> post = controller.createContratante(contratanteDTO);;
        assertEquals(201, post.getStatusCodeValue());
    }

    @Test
    @DisplayName("Validar que esta sendo listado todo os contratantes")
    public void validandoQueEstaSendoListadoTodososContratante(){
        ResponseEntity<Collection<ContratanteDTO>> contratanteDTO = controller.listAll();
    }

    @Test
    @DisplayName("Validar que esta sendo listado todo os contratantes")
    public void validandoQueEstaSendoListadoContratantePeloId(){
        ContratanteDTO contratanteDTO = new ContratanteDTO();

        ResponseEntity<ContratanteDTO> post = controller.createContratante(contratanteDTO);;
        ResponseEntity<ContratanteDTO> contratante = controller.getFreelancerById(contratanteDTO.getId_user());
    }

}
