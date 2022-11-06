package com.nexum.backend.domain.controle.acesso;

import com.nexum.backend.domain.match.Match;
import com.nexum.backend.dto.controle.acesso.UserDTO;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "tb_contratante")
@PrimaryKeyJoinColumn(name = "id_usuario")
public class ContratanteEntity extends UserEntity {
    @OneToMany(
            mappedBy = "contratante",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    @Fetch(FetchMode.SELECT)
    private Collection<Match> match = new ArrayList<>();

    public ContratanteEntity() {
    }

    public ContratanteEntity(UserDTO userDTO) {
        super(userDTO);
    }

    public Collection<Match> getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match.add(match);
    }
}
