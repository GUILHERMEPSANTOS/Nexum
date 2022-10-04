package com.nexum.entities.controle.acesso;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "tb_contratante")
@PrimaryKeyJoinColumn(name = "id_usuario")
public class ContratanteEntity extends UserEntity{
    public ContratanteEntity() {
    }

    public ContratanteEntity(User user) {
        super(user);
    }
}
