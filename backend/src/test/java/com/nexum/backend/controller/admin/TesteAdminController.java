package com.nexum.backend.controller.admin;

import com.nexum.backend.repositories.shared.controle.acesso.SpringUserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TesteAdminController {

    @Autowired
    private AdminController controller;

    @MockBean
    private SpringUserRepository repository;

    @Test
    @DisplayName("Validar que esta sendo feito o download do CSV")
    public void verificarQueEstaFazendoDownloadDoCsv(){
      controller.getFileCSV();
    }


}
