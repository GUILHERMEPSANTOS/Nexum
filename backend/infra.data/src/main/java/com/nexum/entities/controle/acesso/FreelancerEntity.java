package com.nexum.entities.controle.acesso;

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

    public FreelancerEntity(User user) {
        super(user);
    }

}
