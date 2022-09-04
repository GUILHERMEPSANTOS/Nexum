package nexum.springboot.controle.acesso.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "tb_contratante")
@PrimaryKeyJoinColumn(name = "id_contratante")
@Data
public class Contratante extends UserLogin {

    @Column
    @NotEmpty(message = "Senha is required")
    private String senha;

}
