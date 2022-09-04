package nexum.springboot.controle.acesso.repository;

import nexum.springboot.controle.acesso.Model.UserLogin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface UserRepository extends CrudRepository <UserLogin, Long> {
    @Query(value = "EXEC sp_login_usuario ? , ?", nativeQuery = true)
    Map<String, Object> signIn(String email, String senha);
}
