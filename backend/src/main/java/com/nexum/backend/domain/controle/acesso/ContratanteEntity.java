package com.nexum.backend.domain.controle.acesso;

import com.nexum.backend.dto.controle.acesso.UserDTO;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "tb_contratante")
@PrimaryKeyJoinColumn(name = "id_usuario")
public class ContratanteEntity extends UserEntity{

    public ContratanteEntity() {
    }

    public ContratanteEntity(UserDTO userDTO) {
        super(userDTO);
    }
}
