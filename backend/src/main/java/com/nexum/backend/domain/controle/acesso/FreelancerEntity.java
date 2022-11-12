package com.nexum.backend.domain.controle.acesso;

import com.nexum.backend.domain.controle.acesso.interfaces.UserStrategy;
import com.nexum.backend.domain.match.MatchEntity;
import com.nexum.backend.dto.shared.UserDTO;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "tb_freelancer")
@PrimaryKeyJoinColumn(name = "id_usuario")
public class FreelancerEntity extends UserEntity implements UserStrategy {
    @Column
    private String cargo;
    @OneToMany(
            mappedBy = "freelancer",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    @Fetch(FetchMode.SELECT)
    private Collection<MatchEntity> match = new ArrayList<>();

    public FreelancerEntity() {
    }

    public FreelancerEntity(UserDTO userDTO) {
        super(userDTO);
    }

    public Collection<MatchEntity> getMatch() {
        return match;
    }

    public void setMatch(MatchEntity match) {
        this.match.add(match);
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public UserDTO toUserDTO(){
        return new UserDTO(this);
    }
}