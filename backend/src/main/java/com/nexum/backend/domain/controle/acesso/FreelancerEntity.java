package com.nexum.backend.domain.controle.acesso;

import com.nexum.backend.dto.controle.acesso.UserDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "tb_freelancer")
@PrimaryKeyJoinColumn(name = "id_usuario")
public class FreelancerEntity extends UserEntity{
    @Column(length = 500)
    private String descricao;

    public FreelancerEntity() {
    }

    public FreelancerEntity(UserDTO userDTO) {
        super(userDTO);
    }
}
