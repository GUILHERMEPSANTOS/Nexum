package com.nexum.repositories.controle.acesso;

import com.nexum.entities.User;
import com.nexum.entities.controle.acesso.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringUserRepository extends JpaRepository<UserEntity, Long> {}
