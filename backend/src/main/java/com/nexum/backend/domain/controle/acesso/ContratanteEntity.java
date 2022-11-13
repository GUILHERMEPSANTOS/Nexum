package com.nexum.backend.domain.controle.acesso;

import com.nexum.backend.domain.match.MatchEntity;
import com.nexum.backend.dto.shared.UserDTO;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "tb_contratante")
@PrimaryKeyJoinColumn(name = "id_usuario")
public class ContratanteEntity extends UserEntity {
    @OneToMany(mappedBy = "contratante", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Fetch(FetchMode.SELECT)
    private Collection<MatchEntity> match = new ArrayList<>();

    public ContratanteEntity() {
    }

    public ContratanteEntity(Long id_usuario) {
        super(id_usuario);
    }

    public ContratanteEntity(String nome, String email, String senha, String celular) {
        super(nome, email, senha, celular);
    }

    public ContratanteEntity(UserDTO userDTO) {
        super(userDTO);
    }

    public Collection<MatchEntity> getMatch() {
        return match;
    }

    public void setMatch(MatchEntity match) {
        this.match.add(match);
    }

}
