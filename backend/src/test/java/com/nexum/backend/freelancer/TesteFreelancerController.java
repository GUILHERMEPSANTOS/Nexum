package com.nexum.backend.freelancer;

import com.nexum.backend.controller.freelancer.FreelancerController;
import com.nexum.backend.dto.contratante.ContratanteDTO;
import com.nexum.backend.dto.freelancer.FreelancerDTO;
import com.nexum.backend.repositories.freelancer.SpringFreelancerRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TesteFreelancerController {

    @Autowired
    private FreelancerController controller;

    @MockBean
    private SpringFreelancerRepository repository;

    @Test
    @DisplayName("Validar que esta sendo criado um novo Freelancer")
    public void validandoQueEstaSendoCriadoContaFreelancer(){
        when(repository.existsById(anyLong()) && repository.existsById(anyLong()))
                .thenReturn(true);

        FreelancerDTO freelancerDTO = new FreelancerDTO();

        ResponseEntity<ContratanteDTO> post = controller.createFreelancer(freelancerDTO);
        assertEquals(201, post.getStatusCodeValue());
    }

    @Test
    @DisplayName("Validar que esta sendo listado todo os Freelancer")
    public void validandoQueEstaSendoListadoTodososFreelancer(){
        ResponseEntity<Collection<FreelancerDTO>> freelancerDTO = controller.listAll();
    }

    @Test
    @DisplayName("Validar que esta sendo listado todo os Freelancer")
    public void validandoQueEstaSendoListadoFreelancerPeloId(){
        FreelancerDTO freelancerDTO = new FreelancerDTO();

        ResponseEntity<FreelancerDTO> post = controller.createFreelancer(freelancerDTO);;
        ResponseEntity<FreelancerDTO> contratante = controller.getFreelancerById(freelancerDTO.getId_user());
    }
}
