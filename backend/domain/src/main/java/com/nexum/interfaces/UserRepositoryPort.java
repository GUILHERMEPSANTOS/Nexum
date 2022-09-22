package com.nexum.interfaces;

import com.nexum.entities.User;

import java.util.List;

public interface UserRepositoryPort {
    void create(User user);
    List<User> list();
    void update(User user);
}
