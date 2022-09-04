package nexum.springboot.controle.acesso.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@AllArgsConstructor
public class UserLoginDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String nome;

    @NotEmpty(message = "email is required")
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotEmpty(message = "senha is required")
    private String senha;
}
