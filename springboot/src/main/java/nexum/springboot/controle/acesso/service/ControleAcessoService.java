package nexum.springboot.controle.acesso.service;

import lombok.AllArgsConstructor;
import nexum.springboot.controle.acesso.Model.UserLogin;
import nexum.springboot.controle.acesso.dto.UserLoginDTO;
import nexum.springboot.controle.acesso.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class ControleAcessoService {

    @Autowired
    private final UserRepository userRepository;

    public Map<String, Object> singIn(UserLoginDTO userLoginDTO) {
        return userRepository.signIn(userLoginDTO.getEmail(), userLoginDTO.getSenha());
    }
}
