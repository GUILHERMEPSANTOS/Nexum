package nexum.springboot.controle.acesso.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "tb_usuario")
@Data
@Inheritance(
        strategy = InheritanceType.JOINED
)
public class UserLogin {

    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotEmpty(message = "Name is required")
    private String name;

    @Column
    @NotEmpty(message = "Email is required")
    @Email(message = "Email is invalid")
    private String email;

}
