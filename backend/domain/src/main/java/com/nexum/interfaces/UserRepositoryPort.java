package com.nexum.interfaces;

import com.nexum.entities.User;
import com.nexum.validation.DomainExceptionValidation;

import java.util.List;

public interface UserRepositoryPort {
    void create(User user);

    List<User> list();

    void update(User user) throws DomainExceptionValidation;

    User findById(Long id) throws DomainExceptionValidation;

}
