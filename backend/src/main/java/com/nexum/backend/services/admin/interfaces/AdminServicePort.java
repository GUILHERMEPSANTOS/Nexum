package com.nexum.backend.services.admin.interfaces;

import com.nexum.backend.domain.controle.acesso.UserEntity;
import com.nexum.backend.dto.freelancer.FreelancerDTO;
import org.springframework.core.io.InputStreamResource;

import java.util.Collection;

public interface AdminServicePort {
    InputStreamResource load();
    void gravaRegistro(String registro, String nomeArq);
    void gravaArquivoTxt(Collection<UserEntity> lista, String nomeArq);
    void leArquivoTxt(String nomeArq);
    Collection<UserEntity> listAll();
    Integer countNumberFreelancers();
    Integer countNumberContratantes();
}
