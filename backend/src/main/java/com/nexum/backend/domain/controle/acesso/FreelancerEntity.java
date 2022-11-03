package com.nexum.backend.domain.controle.acesso;

import com.nexum.backend.domain.habilidades.HabilidadeEntity;
import com.nexum.backend.domain.social.SocialUserEntity;
import com.nexum.backend.dto.controle.acesso.UserDTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "tb_freelancer")
@PrimaryKeyJoinColumn(name = "id_usuario")
public class FreelancerEntity extends UserEntity {
    @Column
    private String cargo;
    @ManyToMany
    @JoinTable(name = "TB_USERS_HABILIDADES",
            joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_habilidade")
    )
    private Collection<HabilidadeEntity> habilidades = new ArrayList<>();

    public FreelancerEntity() {
    }

    public FreelancerEntity(UserDTO userDTO) {
        super(userDTO);
    }

    public Collection<HabilidadeEntity> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(HabilidadeEntity habilidade) {
        this.habilidades.add(habilidade);
    }
}
